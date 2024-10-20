package homework1810;


import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShootingCompetition {

    // AtomicBoolean для контроля, поражена ли мишень
    private static final AtomicBoolean isHit = new AtomicBoolean(false);

    public static void main(String[] args) {
        // Создаем пять потоков для каждого стрелка
        for (int i = 1; i <= 5; i++) {
            new Thread(new Shooter(i)).start();
        }
    }

    // Класс стрелка, реализующий интерфейс Runnable
    static class Shooter implements Runnable {
        private int id;
        private Random random = new Random();

        Shooter(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Стрелок "целится" на случайное время
                Thread.sleep(random.nextInt(1000));

                // Проверяем, если мишень еще не была поражена
                if (isHit.compareAndSet(false, true)) {
                    System.out.println("Стрелок " + id + " попал в мишень!");
                } else {
                    System.out.println("Стрелок " + id + " промахнулся, мишень уже поражена.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
