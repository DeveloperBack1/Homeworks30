package multithreading.tutorial_2110;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        // Threadpooli, sozdannije s pomoshju metodov( Fabrika objektov)
        ExecutorService executorService = Executors.newFixedThreadPool(5); // s 5 potokami
      //  ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //  Threadpool s odnim potokom

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnableimpl100());

        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS); // Potok Main budet shdat 5 sekund,
        // poka executorservice otrabotaet
        System.out.println("Main ends");
    }
}

class Runnableimpl100 implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
