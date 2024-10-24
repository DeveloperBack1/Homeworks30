package homework2310;

//Для подъема на смотровую площадку работает лифт, в который одновременно
//        может сесть не более 5 человек.
//        Создайте программу-симулятор работы лифта, при разном
//        количестве людей в группе(можно вводить с клавиатуры).
//        Каждый человек - отдельный поток.

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MainElevator {

    // Лифт имеет вместимость 5 человек
    private static final int CAPACITY = 5;
    private static Semaphore elevator = new Semaphore(CAPACITY);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество людей в группе: ");
        int numberOfPeople = scanner.nextInt();

        // Запускаем потоки для каждого человека
        for (int i = 1; i <= numberOfPeople; i++) {
            new Thread(new Person("Человек " + i)).start();
        }

        scanner.close();
    }


    static class Person implements Runnable {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " подошел к лифту и ждет места.");

                // Человек пытается зайти в лифт (занять место)
                elevator.acquire();
                System.out.println(name + " зашел в лифт.");


                Thread.sleep(2000); // человек едет 2 секунды

                System.out.println(name + " вышел из лифта.");

                // Человек выходит из лифта
                elevator.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
