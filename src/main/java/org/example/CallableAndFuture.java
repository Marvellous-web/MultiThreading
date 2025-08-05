package org.example;

import java.util.concurrent.*;

//
//🔷 1. Runnable vs Callable – Basic Difference
//Feature	Runnable	Callable<V>
//Return value	❌ No return value	✅ Can return a result
//Exception handling	❌ Can't throw checked exceptions	✅ Can throw checked exceptions
//Method	run()	call()
public class CallableAndFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // 1 thread

        Callable<String> task = () -> {
            Thread.sleep(2000); // 2 seconds रुको
            return "🎯 Result aaya!";
        };

        Future<String> future = executor.submit(task); // काम चला दिया

        System.out.println("Task submitted... result ka wait...");

        String result = future.get(); // यहीं रुक जाएगा जब तक काम complete नहीं होता

        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
