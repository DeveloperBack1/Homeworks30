package homework_2009.task1;

import java.util.*;

public class CityPeople {

    public static void main(String[] args) {
        // Создаем Map с данными о городах и количестве жителей
        Map<String, Integer> cityPopulation = new HashMap<>();
        cityPopulation.put("Берлин", 4000000);
        cityPopulation.put("Гамбург", 2000000);
        cityPopulation.put("Дрезден", 600000);
        cityPopulation.put("Бремен", 500000);
        cityPopulation.put("Мюнхен", 1400000);
        cityPopulation.put("Штуттгарт", 800000);
        cityPopulation.put("Кёльн", 600000);

        // 1. Найти город с самым большим количеством жителей
        String largestCity = null;
        int maxPopulation = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            if (entry.getValue() > maxPopulation) {
                maxPopulation = entry.getValue();
                largestCity = entry.getKey();
            }
        }

        System.out.println("Город с самым большим количеством жителей: " + largestCity + " (Количество жителей: " + maxPopulation + ")");

        // 2. Найти среднее количество жителей по всем городам
        int totalPopulation = 0;
        for (int population : cityPopulation.values()) {
            totalPopulation += population;
        }

        double averagePopulation = totalPopulation / (double) cityPopulation.size();
        System.out.println("Среднее количество жителей по всем городам: " + averagePopulation);

        // 3. Найти все города, у которых количество жителей одинаковое
        Map<Integer, List<String>> populationCitiesMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
            int population = entry.getValue();
            String city = entry.getKey();

            populationCitiesMap.computeIfAbsent(population, k -> new ArrayList<>()).add(city);
        }

        System.out.println("Города с одинаковым количеством жителей:");
        for (Map.Entry<Integer, List<String>> entry : populationCitiesMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("Количество жителей: " + entry.getKey() + " - Города: " + entry.getValue());
            }
        }
    }
}