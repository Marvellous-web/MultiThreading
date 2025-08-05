class OfficeNotify {
    boolean workAssigned = false;

    synchronized void waitForWork(String name) throws InterruptedException {
        System.out.println(name + ": Waiting for work...");
        while (!workAssigned) {
            wait();
        }
        System.out.println(name + ": Got the work!");
    }

    synchronized void assignWork() {
        workAssigned = true;
        System.out.println("Boss: Assigned work, notifying one employee.");
//        notify(); // Notify one employee
        notifyAll();
    }
}

public class NotifyExample {
    public static void main(String[] args) throws InterruptedException {
        OfficeNotify office = new OfficeNotify();

        Thread emp1 = new Thread(() -> {
            try {
                office.waitForWork("Employee-1");
            } catch (InterruptedException e) {}
        });

        Thread emp2 = new Thread(() -> {
            try {
                office.waitForWork("Employee-2");
            } catch (InterruptedException e) {}
        });

        emp1.start();
        emp2.start();

        Thread.sleep(500);

        new Thread(() -> {
            office.assignWork();
        }).start();
    }
}
