package multithreading.wait_notify_message;

public class Publisher implements Runnable {

    private Message message;

    public Publisher(Message message) {
        this.message = message;

    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал.");
        try {
            Thread.sleep(1000);
            synchronized (message) {
                System.out.println(name + " начал создавать сообщение.");
                message.setMessage(name + "  -> создал сообщение N1!");
                //    message.notify(); // один поток получит сигнал
                message.notifyAll(); // все потоки, который в wait получат сигнал
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
