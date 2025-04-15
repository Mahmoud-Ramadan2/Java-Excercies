package org.example;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock();

    public void criticalSection() {
        lock.lock(); // Acquire the lock
        try {
            System.out.println(Thread.currentThread().getName() + " mmmmmmmm executing...");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Ensure unlocking in `finally`
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();

        Runnable task = () -> example.criticalSection();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t2.start();
        t1.start();
    }
}
