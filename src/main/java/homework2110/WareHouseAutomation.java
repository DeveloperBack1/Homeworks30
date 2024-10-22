package homework2110;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ramp {
    private final int capacity;
    private final Queue<Integer> rampQueue = new LinkedList<>();

    public Ramp(int capacity) {
        this.capacity = capacity;
    }

    // Метод для разгрузчика: кладет ящик на рампу
    public synchronized void placeBox(int boxId) throws InterruptedException {
        while (rampQueue.size() == capacity) {
            System.out.println("Рампа полна. Разгрузчик ждет освобождения места...");
            wait(); // Ждем, пока погрузчики освободят место на рампе
        }
        rampQueue.add(boxId);
        System.out.println("Разгрузчик положил ящик " + boxId + " на рампу.");
        notifyAll(); // Уведомляем погрузчиков, что есть ящик на рампе
    }

    // Метод для погрузчика: забирает ящик с рампы
    public synchronized int takeBox() throws InterruptedException {
        while (rampQueue.isEmpty()) {
            System.out.println("Рампа пуста. Погрузчик ждет...");
            wait(); // Ждем, пока разгрузчик не положит ящик на рампу
        }
        int boxId = rampQueue.poll();
        System.out.println("Погрузчик забрал ящик " + boxId + " с рампы.");
        notifyAll(); // Уведомляем разгрузчика, что освободилось место на рампе
        return boxId;
    }
}

class Unloader implements Runnable {
    private final Ramp ramp;
    private final int boxCount;

    public Unloader(Ramp ramp, int boxCount) {
        this.ramp = ramp;
        this.boxCount = boxCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= boxCount; i++) {
                Thread.sleep(500); // Имитируем время, необходимое для разгрузки
                ramp.placeBox(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Loader implements Runnable {
    private final Ramp ramp;

    public Loader(Ramp ramp) {
        this.ramp = ramp;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // Имитируем время, необходимое для погрузки и перевозки
                ramp.takeBox();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class WareHouseAutomation {
    public static void main(String[] args) {
        // Ввод количества ящиков с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ящиков в машине:");
        int boxCount = scanner.nextInt();

        System.out.println("Введите максимальную емкость рампы (например, 2):");
        int rampCapacity = scanner.nextInt();

        Ramp ramp = new Ramp(rampCapacity);

        // Создаем и запускаем поток для разгрузчика
        Thread unloaderThread = new Thread(new Unloader(ramp, boxCount));
        unloaderThread.start();

        // Создаем и запускаем несколько потоков для погрузчиков
        Thread loader1 = new Thread(new Loader(ramp));
        Thread loader2 = new Thread(new Loader(ramp));

        loader1.start();
        loader2.start();



        // Ждем завершения разгрузки
        try {
            unloaderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Завершаем работу погрузчиков после разгрузки всех ящиков
       loader1.interrupt();
       loader2.interrupt();
        System.out.println("Разгрузка завершена.");
    }
}
