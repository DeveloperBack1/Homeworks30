package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Max", lock);
        new Employee("Viktor", lock);
        new Employee("Semjon", lock);
        new Employee("Sascha", lock);
        new Employee("Elena", lock);
        new Employee("Michael", lock);
        new Employee("Jack", lock);


    }
}
class Employee extends Thread {
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run(){
        System.out.println(name + " kommt an den Bankomat");
        lock.lock();
        System.out.println(name + " benutzt den Bankommat");
        try {
            Thread.sleep(3000);
            System.out.println(name + " ist fertig mit dem Geldabheben");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }

    }
}