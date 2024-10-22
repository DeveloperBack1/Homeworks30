package multithreading;

//Напишите задачу для поиска всех простых числа в диапазоне до 1 000 000.
//  Напишите программу, запустив которую вы сможете определить оптимальное количество
//  создаваемых потоков для выполнения этой задачи на текущем компьютере.
//  Используйте общее время выполнения программы при обработке всего диапазона чисел
//  для расчета оптимального количества созданных потоков.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeNumbersMultiThreaded {
    // Диапазон поиска простых чисел
    private static final int MAX_NUMBER = 1_000_000;

    // Метод для проверки, является ли число простым
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Основной метод для поиска простых чисел с заданным количеством потоков
    public static void findPrimesWithThreads(int threadCount) throws InterruptedException {
        // Создаем пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Integer> primes = new ArrayList<>();

        // Разбиваем диапазон на поддиапазоны для каждого потока
        int chunkSize = MAX_NUMBER / threadCount;

        // Запускаем каждый поток на отдельном поддиапазоне
        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunkSize;
            final int end = (i == threadCount - 1) ? MAX_NUMBER : (i + 1) * chunkSize;

            executor.submit(() -> {
                List<Integer> localPrimes = new ArrayList<>();
                for (int j = start; j < end; j++) {
                    if (isPrime(j)) {
                        localPrimes.add(j);
                    }
                }
                synchronized (primes) {
                    primes.addAll(localPrimes);
                }
            });
        }

        // Завершаем работу пула потоков
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    // Метод для поиска оптимального количества потоков
    public static void findOptimalThreadCount() throws InterruptedException {
        int optimalThreadCount = 1;
        long bestTime = Long.MAX_VALUE;

        // Пробуем от 1 до 16 потоков
        for (int threadCount = 1; threadCount <= 16; threadCount++) {
            long startTime = System.currentTimeMillis();
            findPrimesWithThreads(threadCount);
            long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;
            System.out.println("Thread count: " + threadCount + ", Time: " + duration + "ms");

            if (duration < bestTime) {
                bestTime = duration;
                optimalThreadCount = threadCount;
            }
        }

        System.out.println("Optimal thread count: " + optimalThreadCount);
    }

    public static void main(String[] args) throws InterruptedException {
        // Определяем оптимальное количество потоков для данной задачи
        findOptimalThreadCount();
    }
}
