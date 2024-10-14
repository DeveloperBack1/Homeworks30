package homework1410;
//
//Запустите в 3 потока просчет суммы всех чисел, который без остатка деляться на 17
//в интервале от 0 до 10 млн. Показывайте на экран, как будет накапливаться сумма по каждому потоку.
//После запуска просчета, главный поток остановите на 1 секунду и завершите его.
//Все дочерние потоки должны автоматически закрыться. (Daemons)

public class SumDivisibleBy17 {
    public static void main(String[] args) throws InterruptedException {

        // Создаем 3 потока для просчета
        Thread thread1 = new Thread(new SumTask(0, 3333333), "Thread-1");
        Thread thread2 = new Thread(new SumTask(3333334, 6666666), "Thread-2");
        Thread thread3 = new Thread(new SumTask(6666667, 10000000), "Thread-3");

        // Устанавливаем потоки как демоны
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();

        // Останавливаем главный поток на 1 секунду
        Thread.sleep(1000);

        System.out.println("Главный поток завершен.");
    }
}

class SumTask implements Runnable {
    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            if (i % 17 == 0) {
                sum += i;
                // Печатаем промежуточные результаты
                System.out.println(Thread.currentThread().getName() + ": Current sum = " + sum);
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Final sum = " + sum);
    }
}
