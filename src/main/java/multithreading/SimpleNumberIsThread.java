package multithreading;



public class SimpleNumberIsThread extends Thread{
    private int start;
    private  int end;
    public int count;

    public SimpleNumberIsThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        count = 0;
        for (int i = start; i < end; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }
    }
}