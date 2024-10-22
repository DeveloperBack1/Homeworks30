package multithreading;

import static java.lang.System.*;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
getCountDiv(0,Integer.MAX_VALUE/2, 13);
long currentTime = currentTimeMillis();
ThreadTask threadTask1 = new ThreadTask(0,Integer.MAX_VALUE/4,13);
ThreadTask threadTask2 = new ThreadTask(Integer.MAX_VALUE/4+1, Integer.MAX_VALUE/2,13);
threadTask1.start();
threadTask2.start();

threadTask1.join();
threadTask2.join();

     System.out.println("Gemeinsame Zeit der Ausführung: "+ (System.currentTimeMillis()-currentTime));

        // Runnable
        currentTime = System.currentTimeMillis();
        ThreadTaskRun taskRun1 = new ThreadTaskRun(0, Integer.MAX_VALUE/4, 13);
        ThreadTaskRun taskRun2 = new ThreadTaskRun(Integer.MAX_VALUE/4+1, Integer.MAX_VALUE/2, 13);

        Thread th1 = new Thread(taskRun1, "Task1");
        Thread th2 = new Thread(taskRun2, "Task2");
        th1.start();
        th2.start();
// заставляем главный поток ждать завершения дочерних
        th1.join();
        th2.join();
        System.out.println("Общее время выполнения (Runnable) = "+(System.currentTimeMillis()-currentTime));
    }


    private static void getCountDiv(int start, int end, int div) {
        long currentTime = currentTimeMillis();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % div == 0) {
                count++;
            }
        }
        out.println("Количество = " + count);
        out.println("Время выполнения = " + (currentTimeMillis() - currentTime));
    }

    static class ThreadTask extends Thread {
        private int start;
        private int end;
        private int div;
        public int count;

        public ThreadTask(int start, int end, int div) {
            this.start = start;
            this.end = end;
            this.div = div;
        }

        @Override
        public void run() {
            long currentTime = currentTimeMillis();

            for (int i = start; i <= end; i++) {
                if (i % div == 0) {
                    count++;
                }
            }
            out.println(Thread.currentThread().getName() + " -> количество = " + count);
            out.println(Thread.currentThread().getName() + " -> время выполнения = " + (currentTimeMillis() - currentTime));
        }
    }

    static class ThreadTaskRun  implements Runnable {
        private int start;
        private int end;
        private int div;
        public int count;

        public ThreadTaskRun(int start, int end, int div) {
            this.start = start;
            this.end = end;
            this.div = div;
        }

        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();

            for (int i = start; i <= end; i++) {
                if(i % div == 0) {
                    count++;
                }
            }
            System.out.println(Thread.currentThread().getName()+" -> количество = "+count);
            System.out.println(Thread.currentThread().getName()+" -> время выполнения = "+(System.currentTimeMillis()-currentTime));

        }
    }
}
