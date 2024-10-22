package multithreading.tutorial_2110;

public class WaitNotifyExample {
    public static void main(String[] args) {
      Market market = new Market();
      Producer producer = new Producer(market);
      Consumer consumer = new Consumer(market);
      new Thread(producer).start();
      new Thread(consumer).start();

    }
}
class Market{
    private int breadCount;
    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб!");
        System.out.println("Количество хлеба в магазине=" + breadCount);
        notify();


    }
    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб!");
        System.out.println("Количество хлеба в магазине= " + breadCount);
        notify();
    }
}

class Producer implements Runnable{
    private Market market;
    public Producer(Market market) {
        this.market = market;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
          market.putBread();
      }
    }
}
class Consumer implements Runnable{
    private Market market;
    public Consumer(Market market) {
        this.market = market;

    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}