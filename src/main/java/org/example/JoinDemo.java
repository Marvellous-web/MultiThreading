package org.example;

class DemoThread extends Thread {
    public void run() {
        try {
            for(int i=0;i<5;i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch(Exception e) {}
    }
}

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        DemoThread t1 = new DemoThread();
        t1.start();
        t1.join();
        System.out.println("Main thread ends after t1 finishes");
    }
}
