package homework2310;
//1. У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь корректно всех
// обслужить с учетом того,
//        что одновременно у вас внутри магазина может находиться не более
//        10 покупателей(согласно карантинным нормам)
//        и время обслуживания одного покупателя занимает 30 секунд(откорректируйте под себя).
//        Сымитируйте данный процесс
//        работы и подсчитайте за какой период времени вы сможете обслужить данный объем покупателей?
//        Отдельный покупатель - отдельный поток. Какой синхронизатор с библиотеки
//        concurrent Вы бы использовали?

//Общее время обслуживания
//(10000/10)*30 = 30000 sek. 8 h 20 min

import java.util.concurrent.*;

public class StoreSimulation {
    private static final int TOTAL_CUSTOMERS = 10000;   // Общее количество покупателей
    private static final int MAX_CUSTOMERS_IN_STORE = 10; // Максимальное количество покупателей в магазине
    private static final int SERVICE_TIME = 30000; // Время обслуживания одного покупателя (в миллисекундах)

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(MAX_CUSTOMERS_IN_STORE); // Создаем семафор с ограничением
        // на количество покупателей в магазине
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_CUSTOMERS); // Создаем пул потоков

        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            executorService.submit(new Customer(semaphore, i + 1));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Customer implements Runnable {
        private Semaphore semaphore;
        private int customerId;

        public Customer(Semaphore semaphore, int customerId) {
            this.semaphore = semaphore;
            this.customerId = customerId;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // Получаем доступ в магазин
                System.out.println("Customer " + customerId + " is being served.");
                Thread.sleep(SERVICE_TIME); // Обслуживание покупателя
                System.out.println("Customer " + customerId + " has been served.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Покупатель выходит из магазина
            }
        }
    }
}
