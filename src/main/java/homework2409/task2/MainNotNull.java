package homework2409.task2;


import java.util.function.Predicate;

public class MainNotNull {
    public static void main(String[] args) {
        Predicate<String> isNotNull = s -> s != null;

        System.out.println(isNotNull.test("Hello")); // true
        System.out.println(isNotNull.test(null));    // false
    }
}
