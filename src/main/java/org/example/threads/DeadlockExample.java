package org.example.threads;

class Resource {
    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void use(Resource other) {
        System.out.println(Thread.currentThread().getName() + " is using " + this.name);
        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is trying to use " + other.getName());
        other.use(this);
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        Thread t1 = new Thread(() -> resource1.use(resource2), "Thread-1");
        Thread t2 = new Thread(() -> resource2.use(resource1), "Thread-2");

        t1.start();
        t2.start();
    }
}