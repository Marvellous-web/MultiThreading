package org.example.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample2 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
            .thenApply(s -> s + " World")              // modify result
            .thenAccept(s -> System.out.println(s))    // consume result
            .thenRun(() -> System.out.println("Done")); // run final task
    }
}
