package org.example;

class Counter {
    int count = 0;
//    void increment() { count++; }
 synchronized void increment() { count++; }
}
class MyThread1 extends Thread {
    Counter c;
    MyThread1(Counter c) { this.c = c; }
    public void run() {
        for(int i=0;i<10000;i++) c.increment();
    }
}
public class WithoutSyncAndWithSync {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        MyThread1 t1 = new MyThread1(c);
        MyThread1 t2 = new MyThread1(c);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count: " + c.count); // Result will be inconsistent!
    }
}
