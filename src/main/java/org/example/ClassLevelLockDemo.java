package org.example;

class ClassLockShared {
    // Static synchronized method = Class-level lock
    public static synchronized void display(String name) {
        System.out.println("Start: " + name);
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End: " + name);
    }
}

class MyThread2 extends Thread {
    String name;

    MyThread2(String name) {
        this.name = name;
    }

    public void run() {
        ClassLockShared.display(name);
    }
}

public class ClassLevelLockDemo {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("Thread-1");
        MyThread2 t2 = new MyThread2("Thread-2");

        t1.start();
        t2.start();
    }
}
