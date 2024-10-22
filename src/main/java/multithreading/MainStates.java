package multithreading;

public class MainStates {
    public static void main(String[] args) {
        Thread thread = new Thread(){
           public void run(){
                System.out.println("2. "+getState());
                int count = 0;
               for (int i = 0; i < 10000; i++) {
                  if(i%17 ==0){
                      count++;
                      System.out.println(getState());
                  }
               }
            }
        };
        System.out.println("1. "+thread.getState());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("3. "+thread.getState());
    }
}
