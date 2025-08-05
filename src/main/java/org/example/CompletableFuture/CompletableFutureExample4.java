package org.example.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample4 {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (Exception e) {}
            return "Data from API 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1500); } catch (Exception e) {}
            return "Data from API 2";
        });

        CompletableFuture<Void> combined = CompletableFuture.allOf(future1, future2);

        combined.thenRun(() -> {
            try {
                System.out.println(future1.get());
                System.out.println(future2.get());
            } catch (Exception e) {}
        });

        Thread.sleep(3000); // wait to see output
    }
}
