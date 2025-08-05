package org.example;

class Printer {
    // This method uses object lock (this)
    synchronized void printDocument(String docName, int pages) {
        for (int i = 1; i <= pages; i++) {
            System.out.println(Thread.currentThread().getName() + " printing " + docName + " page " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ObjectLockExample {
    public static void main(String[] args) {
        Printer printer = new Printer(); // Only one object

        // Thread 1 - prints Document A
        Thread t1 = new Thread(() -> {
            printer.printDocument("Document-A", 3);
        }, "Employee-1");

        // Thread 2 - prints Document B
        Thread t2 = new Thread(() -> {
            printer.printDocument("Document-B", 3);
        }, "Employee-2");

        t1.start();
        t2.start();
    }
}
