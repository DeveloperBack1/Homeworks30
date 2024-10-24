package homework2310;

//Кассир в магазине. К нему подходят клиенты с товарам отдают ему деньги и получают сдачу.
//        По окончанию работы кассир подсчитывает сумму в кассе и сдает выручку.
//        Кассир и каждый покупатель - это отдельные потоки. Сымитируйте данный процесс работы. Сумма оплаты и
//        сумма сдачи может быть сгенерирована случайным образом, чтобы сдача была всегда меньше чем оплата.
//        Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?


import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class MainCashierWithExchanger {

    private static double totalCash = 0.0; // Общая сумма денег в кассе

    public static void main(String[] args) {
        // Создаем Exchanger
        Exchanger<Transaction> exchanger = new Exchanger<>();

        // Запускаем кассира в отдельном потоке
        ExecutorService service = Executors.newFixedThreadPool(6); // 5 клиентов + кассир
        service.submit(new Cashier(exchanger));

        // Создаем и запускаем потоки для клиентов
        for (int i = 0; i < 5; i++) {
            service.submit(new Client("Клиент " + (i + 1), exchanger));
        }

        service.shutdown();
    }

    // Класс клиента
    static class Client implements Runnable {
        private String name;
        private Exchanger<Transaction> exchanger;

        public Client(String name, Exchanger<Transaction> exchanger) {
            this.name = name;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {

                // Генерируем случайные значения оплаты и сдачи
                double payment = 50 + (100 - 50) * random.nextDouble(); // Оплата от 50 до 100
                double change = payment - (10 + (payment - 10) * random.nextDouble()); // Сдача меньше оплаты

                // Отправляем транзакцию кассиру
                System.out.printf("%s передает кассиру оплату: %.2f, и получает сдачу: %.2f\n", name, payment, change);
                exchanger.exchange(new Transaction(payment, change));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Класс кассира
    static class Cashier implements Runnable {
        private Exchanger<Transaction> exchanger;

        public Cashier(Exchanger<Transaction> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    // Принимаем  от клиента
                    Transaction transaction = exchanger.exchange(null);

                    // Рассчитываем и добавляем выручку в кассу
                    double net = transaction.getPayment() - transaction.getChange();
                    totalCash += net;
                    System.out.printf("Кассир обработал транзакцию: оплата %.2f, сдача %.2f, добавлено в кассу: %.2f",
                            transaction.getPayment(), transaction.getChange(), net);
                }

                // Подсчет общей суммы в кассе
                System.out.printf("Общая сумма в кассе по окончанию работы: %.2f"+ totalCash);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Класс для представления транзакции
    static class Transaction {
        private double payment;
        private double change;

        public Transaction(double payment, double change) {
            this.payment = payment;
            this.change = change;
        }

        public double getPayment() {
            return payment;
        }

        public double getChange() {
            return change;
        }
    }
}
