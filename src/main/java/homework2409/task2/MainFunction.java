package homework2409.task2;


import java.util.function.Function;

public class MainFunction {
    public static void main(String[] args) {
        Function<Integer, String> numberCheck = number -> {
            if (number > 0) return "Положительное число";
            if (number < 0) return "Отрицательное число";
            return "Ноль";
        };

        System.out.println(numberCheck.apply(5));  // Положительное число
        System.out.println(numberCheck.apply(-43)); // Отрицательное число
        System.out.println(numberCheck.apply(0));  // Ноль
    }
}
