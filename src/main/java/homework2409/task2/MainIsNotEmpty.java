package homework2409.task2;


import java.util.function.Predicate;

public class MainIsNotEmpty {
    public static void main(String[] args) {
        Predicate<String> isNotEmpty = s -> s != null && !s.isEmpty();

        System.out.println(isNotEmpty.test("Hello")); // true
        System.out.println(isNotEmpty.test(""));      // false
    }
}
