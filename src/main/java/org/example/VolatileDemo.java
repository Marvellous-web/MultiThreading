package org.example;

public class VolatileDemo extends Thread {
    // Shared volatile variable
     volatile boolean flag = false;

    // This thread waits for flag to become true
    public void run() {
        System.out.println("Thread started and waiting for flag to become true...");
        while (!flag) {
//            System.out.println("Hello");
            // Busy-wait loop; this would hang if 'flag' wasn't volatile
        }
        System.out.println("Thread detected flag change to true");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();

        // Start the thread which checks the flag
        demo.start();

        // Sleep for a short time to ensure the thread starts and enters the loop
        Thread.sleep(2000);

        // Change the flag after delay
        System.out.println("Main thread changing flag to true...");
        demo.flag = true;
    }
}
