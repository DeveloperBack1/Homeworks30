package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int number = scanner.nextInt();
//        System.out.println("Die Zahl, die ich eingegeben habe, ist: "+number);

//        System.out.println("Enter a 2 numbers: ");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        System.out.println("Chastnoe = "+ x/y);
//        System.out.println("Ostatok = "+ x%y);

//        System.out.println("Napishite paru slov: ");
//        String s = scanner.nextLine();
//        String v = scanner.nextLine();
//        System.out.println("Vi napoisali: "+s+" i "+v);

        Scanner scanner1 = new Scanner("Privet moj drug\nKak poshivaesch?\n"+"Chto horoshego?");
//        while (scanner1.hasNextLine()) {
//            System.out.println(scanner1.nextLine());
//        }
        System.out.println(scanner1.next().charAt(3)); // vivodit simwol pod 3 indexom.

    }
}
