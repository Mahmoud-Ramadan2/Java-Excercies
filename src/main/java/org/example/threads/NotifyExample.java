package org.example.threads;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SharedResource {
    private boolean available = false;

    public synchronized void waitForResource() throws InterruptedException {
        while (!available) {
            wait(); // Wait until the resource is available
        }
        System.out.println(Thread.currentThread().getName() + " has acquired the resource.");
    }

    public synchronized void releaseResource() {
        available = true;
        // notify(); // Wakes up one waiting thread
        notifyAll(); // Wakes up all waiting threads
    }
}

public class NotifyExample {
    public static void main(String[] args) {






        SharedResource resource = new SharedResource();

        Runnable task = () -> {
            try {
                resource.waitForResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(2000); // Simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resource.releaseResource(); // Release the resource and notify threads
    }
}