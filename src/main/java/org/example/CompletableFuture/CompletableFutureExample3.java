package org.example.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample3 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Some error");
            return "Success";
        }).exceptionally(ex -> {
            return "❌ Error handled: " + ex.getMessage();
        });

        future.thenAccept(System.out::println);
    }
}
