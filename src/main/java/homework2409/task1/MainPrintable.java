package homework2409.task1;

public class MainPrintable {
    public static void main(String[] args) {
        // Лямбда-выражение для печати текста в верхнем регистре
        Printable printUpperCase = text -> System.out.println(text.toUpperCase());

        // Лямбда-выражение для печати текста в нижнем регистре
        Printable printLowerCase = text -> System.out.println(text.toLowerCase());

        printUpperCase.print("Hello World!");
        printLowerCase.print("Hello World!");
    }
}
