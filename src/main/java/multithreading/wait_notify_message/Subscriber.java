package multithreading.wait_notify_message;

public class Subscriber implements Runnable {
    private Message message;

    public Subscriber(Message message) {
        this.message = message;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println(name + " ждет сообщения (notify): " + System.currentTimeMillis());
                //  message.wait();
                message.wait(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " начинаем обрабатывать сообщение (notify): " + System.currentTimeMillis());
            // обрабатывам сообщение
            System.out.println(name + " обработал =====> " + (message.getMessage()));
            System.out.println(name + " закончил обрабатывать сообщение (notify): " + System.currentTimeMillis());
        }
    }
}
