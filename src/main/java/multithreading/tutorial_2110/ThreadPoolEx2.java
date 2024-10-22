package multithreading.tutorial_2110;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);
//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(new Runnableimpl200());
      //  scheduledExecutorService.schedule(new Runnableimpl200(),3, TimeUnit.SECONDS);
//        scheduledExecutorService.
//            scheduleAtFixedRate(new Runnableimpl200(),3,2,TimeUnit.SECONDS);
        scheduledExecutorService.
            scheduleWithFixedDelay(new Runnableimpl200(),3,1,TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
        }
    }

class Runnableimpl200 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" begins work!");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Thread.currentThread().getName()+" ends work!");
    }
}