package lesson4;

public class MainPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();

        int[] arrInt = {1,2,3,4,5};
        printer.print(arrInt);

        String[] str = {"f", "g", "k"};
        printer.<String>print(str);
    }
}
