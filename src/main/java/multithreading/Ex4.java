package multithreading;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Privet!");
            }
        }).start();
        new Thread(() -> System.out.println("Public!")).start();
    }
}
