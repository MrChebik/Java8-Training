package ru.mrchebik.task3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Task:
 *      Generate 1,000 threads, each of which increments a counter 100,000 times. Compare the performance of using
 *  'AtomicLong' versus 'LongAdder'.
 *
 * Created by mrchebik on 8/28/17.
 */
public class Main {
    public static void main(String[] args) {
        testAtomic();
        testLong();
    }

    private static void testAtomic() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        AtomicLong counter = new AtomicLong();
        CompletableFuture[] futures = new CompletableFuture[1000];

        long start = System.currentTimeMillis();

        IntStream.range(0, 1000).forEach(i ->
                futures[i] = CompletableFuture.runAsync(() ->
                        IntStream.range(0, 100_000).forEach(j ->
                                counter.incrementAndGet()), executor));

        CompletableFuture.allOf(futures).thenAccept((v) -> {
            System.out.println(counter.get());
            System.out.printf("AtomicLong: %d%n", System.currentTimeMillis() - start);
        });
    }

    private static void testLong() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        LongAdder counter = new LongAdder();
        CompletableFuture[] futures = new CompletableFuture[1000];

        long start = System.currentTimeMillis();

        IntStream.range(0, 1000).forEach(i ->
                futures[i] = CompletableFuture.runAsync(() ->
                        IntStream.range(0, 100_000).forEach(j ->
                                counter.increment()), executor));

        CompletableFuture.allOf(futures).thenAccept((v) -> {
            System.out.println(counter.sum());
            System.out.printf("LongAdder : %d%n", System.currentTimeMillis() - start);
        });
    }
}
