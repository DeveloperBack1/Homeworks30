package lesson4;

public class Printer {
    public void print(int [] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
        public<T > void print (T[]arr){
            System.out.println("Ich drücke T[] :");
            for (T value : arr) {
                System.out.println(value + " ");
                System.out.println();
            }
        }
    }
