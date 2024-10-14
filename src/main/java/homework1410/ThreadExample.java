package homework1410;


import java.util.Scanner;

public class ThreadExample {
    public static void main(String[] args) {
        // Ввод числа потоков с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество потоков: ");
        int numberOfThreads = scanner.nextInt();
        scanner.close();

        // Массив для хранения ссылок на потоки
        Thread[] threads = new Thread[numberOfThreads];

        // Создание и запуск потоков
        for (int i = 0; i < numberOfThreads; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println("Поток " + threadNumber + ": вывод номер " + (j + 1));
                    try {
                        Thread.sleep(100); // Интервал 100 миллисекунд
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            threads[i].start(); // Запуск потока
        }

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join(); // Главный поток ждёт завершения каждого дочернего потока
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все потоки завершили работу.");
    }
}
