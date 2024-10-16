package homework1610;


public class PrimeCalculator implements Runnable {
    private final int start;
    private final int end;

    public PrimeCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int primeCount = 0; // Счетчик простых чисел
        for (int i = start; i <= end; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " был прерван.");
                return;
            }
            if (isPrime(i)) {
                primeCount++;
                System.out.println(Thread.currentThread().getName() + " нашел простое число: " + i);
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершен." +
            " Найдено простых чисел: " + primeCount);
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        // Создаем 3 потока для расчета простых чисел в разных диапазонах
        Thread thread1 = new Thread(new PrimeCalculator(2, 333_333), "Поток 1");
        Thread thread2 = new Thread(new PrimeCalculator(333_334, 666_666), "Поток 2");
        Thread thread3 = new Thread(new PrimeCalculator(666_667, 1_000_000), "Поток 3");

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();

        // Ждем 5 секунд и прерываем первый поток
        Thread.sleep(5000);
        thread1.interrupt();
        System.out.println("Поток 1 был принудительно завершен.");

        // Ждем еще 5 секунд и прерываем второй поток
        Thread.sleep(5000);
        thread2.interrupt();
        System.out.println("Поток 2 был принудительно завершен.");

        // Ждем еще 5 секунд и прерываем третий поток
        Thread.sleep(5000);
        thread3.interrupt();
        System.out.println("Поток 3 был принудительно завершен.");

        // Ожидаем завершения всех потоков
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Все потоки завершены.");
    }
}
