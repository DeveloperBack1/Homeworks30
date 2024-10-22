package multithreading.wait_notify;

public class Consumer implements Runnable {
    private Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get(); // забирать товар
        }
    }
}
