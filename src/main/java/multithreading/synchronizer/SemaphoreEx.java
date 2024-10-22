package multithreading.synchronizer;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        Person person1 = new Person("Maxim", callBox);
        Person person2 = new Person("Natascha", callBox);
        Person person3 = new Person("Debora", callBox);
        Person person4 = new Person("Valeria", callBox);
        Person person5 = new Person("Sofia", callBox);
    }
}

class Person extends Thread {
    private Semaphore callBox;
    private String name;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox ;
        this.start();
    }
    public void run() {

        try {
            System.out.println(name + " wartet.....");
            callBox.acquire();
            System.out.println(name + " benutzt Telephone....");
            Thread.sleep(2000);
            System.out.println(name + "s Telephonat wurde beendet...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callBox.release();
    }
}
