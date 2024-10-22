package homework2110;//1. У вас есть стол, на который один робоманипулятор ложит деталь, а второй забирает эту деталь.
//Когда Робот1 положит деталь на стол, он должет обязательно ждать, пока Робот2 заберет эту деталь
//и только тогда ложить следующую. Постройте программу, которая автоматизирует эту работу.
//    Количество деталей, которые должны обработать манипуляторы, пользователь задает с клавиатуры.
//    (wait - notify)


import java.util.Scanner;

class Table {       //Класс Table — имитирует стол,
    // на который кладется деталь. Он содержит флаг hasDetail,
    // который указывает, есть ли деталь на столе.
    private boolean hasDetail = false;

    // Метод для робота1, который кладет деталь на стол
    public synchronized void putDetail() throws InterruptedException {
        while (hasDetail) {
            wait(); // Ждём, пока Робот2 не заберет деталь
        }
        hasDetail = true;
        System.out.println("Робот1 положил деталь на стол.");
        notify(); // Уведомляем Робота2, что деталь на столе
    }

    // Метод для робота2, который забирает деталь со стола
    public synchronized void takeDetail() throws InterruptedException {
        while (!hasDetail) {
            wait(); // Ждём, пока Робот1 не положит деталь
        }
        hasDetail = false;
        System.out.println("Робот2 забрал деталь со стола.");
        notify(); // Уведомляем Робота1, что стол свободен
    }
}

class Robot1 implements Runnable {
    private Table table;
    private int detailCount;

    public Robot1(Table table, int detailCount) {
        this.table = table;
        this.detailCount = detailCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < detailCount; i++) {
                table.putDetail();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Robot2 implements Runnable {
    private Table table;
    private int detailCount;

    public Robot2(Table table, int detailCount) {
        this.table = table;
        this.detailCount = detailCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < detailCount; i++) {
                table.takeDetail();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class RobotAutomation {
    public static void main(String[] args) {
        // Ввод количества деталей с клавиатуры
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество деталей:");
        int detailCount = scanner.nextInt();

        Table table = new Table();



        // Создаем потоки для Робота1 и Робота2
        Thread robot1 = new Thread(new Robot1(table, detailCount));
        Thread robot2 = new Thread(new Robot2(table, detailCount));
        robot1.start();
        robot2.start();

        try {
            robot1.join();
            robot2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Работа завершена.");
    }
}

