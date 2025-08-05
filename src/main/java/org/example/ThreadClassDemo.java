package org.example;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running via Thread class");
    }
}
public class ThreadClassDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
