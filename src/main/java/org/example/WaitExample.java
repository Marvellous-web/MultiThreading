class Office {
    boolean workAssigned = false;

    synchronized void waitForWork() throws InterruptedException {
        System.out.println("Employee: Waiting for work...");
        while (!workAssigned) {
            wait(); // Wait until work is assigned
        }
        System.out.println("Employee: Got the work! Working...");
    }

    synchronized void assignWork() {
        workAssigned = true;
        System.out.println("Boss: Work assigned to employee.");
        notify(); // Notify the waiting employee
    }
}

public class WaitExample {
    public static void main(String[] args) throws InterruptedException {
        Office office = new Office();

        // Thread for employee
       Thread t= new Thread(() -> {
            try {
                office.waitForWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(2000); // Boss comes after 2 seconds

        // Thread for boss
        new Thread(() -> {
            office.assignWork();
        }).start();
    }
}
