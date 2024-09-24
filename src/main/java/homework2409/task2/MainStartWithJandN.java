package homework2409.task2;


import java.util.function.Predicate;

public class MainStartWithJandN {
    public static void main(String[] args) {
        Predicate<String> startsWithJOrNAndEndsWithA = s ->
            (s.startsWith("J") || s.startsWith("N")) && s.endsWith("A");

        System.out.println(startsWithJOrNAndEndsWithA.test("Java"));   // true
        System.out.println(startsWithJOrNAndEndsWithA.test("Ninja"));  // true
        System.out.println(startsWithJOrNAndEndsWithA.test("Hello"));  // false
    }
}
