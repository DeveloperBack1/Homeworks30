package homework2409.task2;


import java.util.function.Predicate;

public class MainNotNullNotEmpty  {
    public static void main(String[] args) {
        Predicate<String> isNotNullAndNotEmpty = s -> s != null && !s.isEmpty();

        System.out.println(isNotNullAndNotEmpty.test("Hello")); // true
        System.out.println(isNotNullAndNotEmpty.test(""));      // false
        System.out.println(isNotNullAndNotEmpty.test(null));    // false
    }
}

