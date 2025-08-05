package org.example;

class PC {
    int value;
    boolean isProduced = false;

    // Producer thread
    synchronized void produce(int v) throws InterruptedException {
        while (isProduced) wait();   // Wait until the value is consumed
        value = v;
        System.out.println("Produced: " + value);
        isProduced = true;
        notify();  // Notify the consumer
    }

    // Consumer thread
    synchronized int consume() throws InterruptedException {
        while (!isProduced) wait();  // Wait until the value is produced
        System.out.println("Consumed: " + value);
        isProduced = false;
        notify();  // Notify the producer
        return value;
    }
}

// Producer Thread
class Producer extends Thread {
    PC pc;

    public Producer(PC pc) {
        this.pc = pc;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                pc.produce(i++);
                Thread.sleep(500);  // simulate time taken to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    PC pc;

    public Consumer(PC pc) {
        this.pc = pc;
    }

    public void run() {
        while (true) {
            try {
                pc.consume();
                Thread.sleep(1000);  // simulate time taken to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class to run
public class VolatileDemoPC {
    public static void main(String[] args) {
        PC pc = new PC();

        Producer producer = new Producer(pc);
        Consumer consumer = new Consumer(pc);

        producer.start();
        consumer.start();
    }
}
