package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        // Create a thread pool of 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 50; i++) {
            int taskNumber = i;  // to keep track of task number
            executor.execute(() -> {
                System.out.println("Task " + taskNumber + " is running on: " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor gracefully after submitting all tasks
        executor.shutdown();
    }
}
