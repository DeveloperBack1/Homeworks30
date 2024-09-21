package homework_2009.task2;

import java.util.TreeMap;

public class MainCat {

    public static void main(String[] args) {
        // TreeMap для хранения котов по имени
        TreeMap<String, Cat> cats = new TreeMap<>();

        // Добавим несколько котов
        cats.put("Milo", new Cat("Milo", 2, 4.5, "Siamese"));
        cats.put("Oliver", new Cat("Oliver", 5, 6.0, "British Shorthair"));
        cats.put("Simba", new Cat("Simba", 4, 7.5, "Maine Coon"));
        cats.put("Luna", new Cat("Luna", 3, 5.0, "Siamese"));
        cats.put("Max", new Cat("Max", 6, 7.5, "Maine Coon"));

        // Порода для поиска (например, "Siamese")
        String breedToFind = "Siamese";
        System.out.println("Коты породы " + breedToFind + ":");
        for (Cat cat : cats.values()) {
            if (cat.breed.equals(breedToFind)) {
                System.out.println(cat.name);
            }
        }

        // Вес для поиска (например, 6.0)
        double weightThreshold = 6.0;
        System.out.println("\nКоты с весом больше " + weightThreshold + " кг:");
        for (Cat cat : cats.values()) {
            if (cat.weight > weightThreshold) {
                System.out.println(cat);
            }
        }

        // Поиск кота с самым большим весом и возрастом одновременно
        Cat heaviestOldestCat = null;
        for (Cat cat : cats.values()) {
            if (heaviestOldestCat == null ||
                (cat.weight > heaviestOldestCat.weight && cat.age > heaviestOldestCat.age)) {
                heaviestOldestCat = cat;
            }
        }
        System.out.println("\nКот с самым большим весом и возрастом одновременно:");
        System.out.println(heaviestOldestCat);
    }
}