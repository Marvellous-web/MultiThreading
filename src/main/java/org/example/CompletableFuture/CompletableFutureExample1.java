package org.example.CompletableFuture;

import java.util.concurrent.*;



//Thsi topic comes after callable and future
//अब हम अगले टॉपिक पर चलते हैं — CompletableFuture 🔥
//ये modern Java (Java 8+) का feature है और बहुत powerful है — क्यों?
//
//        ✅ क्यों इस्तेमाल करें CompletableFuture?
//        🔁 Future.get() में thread block हो जाता है — CompletableFuture non-blocking है
//
//🔗 इसमें chaining होती है (thenApply, thenAccept, thenRun, etc.)
//
//🔄 Async execution, callbacks, exception handling—all in one!
public class CompletableFutureExample1 {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(2000); } catch (Exception e) {}
            return "🚀 Task completed!";
        });

        System.out.println("Task started... waiting for result");

        String result = future.get(); // wait karega
        System.out.println("Result: " + result);
    }
}
