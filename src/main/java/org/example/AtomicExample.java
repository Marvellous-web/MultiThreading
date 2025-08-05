package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    static AtomicInteger atomicCount = new AtomicInteger(0);
    static int normalCount = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {

//                🔍 तो दिक्कत कहाँ हुई?
//                जब दो threads एक ही time पर count++ करते हैं, तब कभी-कभी एक increment खो जाता है।
                atomicCount.incrementAndGet(); // thread-safe
                normalCount++;                 // not thread-safe
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Atomic count: " + atomicCount); // Always 2000
        System.out.println("Normal count: " + normalCount); // Likely < 2000
    }
}
