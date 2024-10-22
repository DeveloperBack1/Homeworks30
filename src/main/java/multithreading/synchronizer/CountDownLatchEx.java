package multithreading.synchronizer;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Friend("Igor", countDownLatch);
        new Friend("Anatolij", countDownLatch);
        new Friend("Vera", countDownLatch);
        new Friend("Sascha", countDownLatch);
        new Friend("Petr", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();

    }

    private static void marketStaffIsOnPlace()  throws InterruptedException {

            Thread.sleep(2000);
            System.out.println("Staff came on workplace");
            countDownLatch.countDown();
            System.out.println("countDownLatch: " + countDownLatch.getCount());

    }

    private static void everythingIsReady() throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown();
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }
}

class Friend extends Thread {
    private CountDownLatch countDownLatch;
    private String name;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();

    }

    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " geht einkaufen!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
