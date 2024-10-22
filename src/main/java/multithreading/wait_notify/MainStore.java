package multithreading.wait_notify;

public class MainStore {
    public static void main(String[] args) {
        Store store = new Store();
        Consumer consumer1 = new Consumer(store);
//Consumer consumer2 = new Consumer(store);
        Producer producer = new Producer(store);

        new Thread(producer).start();
        new Thread(consumer1).start();
//new Thread(consumer2).start();

    }
}
