package org.example;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running via Runnable interface");
    }
}
public class RunnableInterfaceDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
