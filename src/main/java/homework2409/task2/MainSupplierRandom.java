package homework2409.task2;

import java.util.function.Supplier;
import java.util.Random;

public class MainSupplierRandom {
    public static void main(String[] args) {
        Supplier<Integer> randomNumber = () -> new Random().nextInt(11); // nextInt(11) вернет от 0 до 10 включительно

        System.out.println(randomNumber.get()); // случайное число от 0 до 10
        System.out.println(randomNumber.get()); // еще одно случайное число
    }
}
