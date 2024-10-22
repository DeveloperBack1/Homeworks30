package multithreading;

public class MainInterrupt1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main - начал работу.");
// Создаем анонимный класс потока
        Thread t = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + " работает " + j + " раз");
                try {
                    System.out.println(Thread.currentThread().getName() + " сам засыпает " + j + " раз");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " сам просыпается " + j + " раз");
                    // Полезная работа
                    //countSimple(2,100_000);

                    int count = 0;
                    for (int i = 2; i < 100_000; i++) {
                        if (Thread.interrupted()) { // проверка isInterrupted
                            System.out.println("Закрываем сами поток по просьбе, выполнялся " + j + " раз. " + i);
                            // своя логика
                            return; // завершаем работу потока, если необходимо!
                        }
                        boolean isPrime = true;
                        for (int k = 2; k < i; k++) {
                            if (i % k == 0) {
                                isPrime = false;
                                break;
                            }
                        }

                        if (isPrime) {
                            count++;
                        }
                    }

                } catch (InterruptedException e) {
                    System.out.println("InterruptedException - проснулся принудительно " + j + " шаг.");
                    return;
                    //throw new RuntimeException(e);
                }
            }

        });

        t.start();
        Thread.sleep(2000);
        System.out.println("---" + t.getState());
        t.interrupt();
        Thread.sleep(3000);
        System.out.println("---" + t.getState());
        t.interrupt();
    }
}



