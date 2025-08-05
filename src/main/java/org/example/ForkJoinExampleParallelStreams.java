package org.example;

import java.util.concurrent.*;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExampleParallelStreams {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(); // ForkJoin pool

        SimpleSumTask task = new SimpleSumTask(1, 100); // Task: 1 से 100 तक जोड़ो

        int result = pool.invoke(task); // Task run करो

        System.out.println("Sum = " + result); // Output: 5050
    }
}


// RecursiveTask (for returning a value)
class SimpleSumTask extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private static final int THRESHOLD = 10; // छोटा टुकड़ा कब माना जाए

    public SimpleSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // छोटा हिस्सा है, सीधे जोड़ो
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // बड़ा हिस्सा है, दो भागों में बाँटो
            int mid = (start + end) / 2;

            SimpleSumTask leftTask = new SimpleSumTask(start, mid);
            SimpleSumTask rightTask = new SimpleSumTask(mid + 1, end);

            // दोनों को fork करो (अलग thread में भेजो)
            leftTask.fork();
            rightTask.fork();

            // दोनों के results लो
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }
}
