package org.example.lamabda;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running in a separate thread: " + Thread.currentThread().getName());
    }
}

 class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyTask());
        thread.start(); // Runs in a separate thread
        System.out.println(" thread running: " + thread.getState());

        System.out.println("Main thread running: " + Thread.currentThread().getName());
    }
}
