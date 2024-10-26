package homework2510;

//1. Напишите программу просчета количества всех простых в диапазоне до 1 000 000.
//        Просчет выполняйте в 4 потоках, которые создаются с помощью Callable.
//        Получите результаты подсчета из каждого потока и напечатайте общий результат.


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeNumberCounter {

    public static void main(String[] args) {
        int upperLimit = 1_000_000;  // Верхняя граница диапазона
        int numberOfThreads = 4;     // Количество потоков
        int step = upperLimit / numberOfThreads; // Диапазон для каждого потока

        // Создаем пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Callable<Integer>> tasks = new ArrayList<>();

        // Разбиваем диапазон и создаем задачи для каждого потока
        for (int i = 0; i < numberOfThreads; i++) {
            final int start = i * step + 1;
            final int end = (i == numberOfThreads - 1) ? upperLimit : (i + 1) * step;
            tasks.add(new PrimeCounterTask(start, end));
        }

        try {
            // Запускаем все задачи и получаем результаты
            List<Future<Integer>> results = executorService.invokeAll(tasks);
            int totalPrimeCount = 0;

            // Обрабатываем результаты каждого потока
            for (Future<Integer> result : results) {
                totalPrimeCount += result.get();  // Суммируем количество простых чисел
            }

            System.out.println("Общее количество простых чисел до " + upperLimit + ": " + totalPrimeCount);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();  // Останавливаем пул потоков
        }
    }

    // Класс, реализующий Callable, для подсчета простых чисел в диапазоне
    static class PrimeCounterTask implements Callable<Integer> {
        private final int start;
        private final int end;

        public PrimeCounterTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int count = 0;
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            System.out.println("Диапазон: " + start + " - " + end + ", найдено простых: " + count);
            return count;
        }

        // Метод для проверки, является ли число простым
        private boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
