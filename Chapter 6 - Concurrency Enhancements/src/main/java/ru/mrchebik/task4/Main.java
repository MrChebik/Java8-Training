package ru.mrchebik.task4;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Task:
 *      Use a 'LongAccumulator' to compute the maximum or minimum of the accumulated elements.
 *
 * Created by mrchebik on 8/28/17.
 */
public class Main {
    public static void main(String[] args) {
        LongAccumulator maxAccumulator = new LongAccumulator(Math::max, 0);
        LongAccumulator minAccumulator = new LongAccumulator(Math::min, 10000);
        IntStream.range(0, 10).forEach(i -> {
            Thread thread = new Thread(() ->
                    Stream.generate(Math::random).map(d ->
                            Double.valueOf(d * 10000).intValue()).limit(100).forEach(e -> {
                        maxAccumulator.accumulate(e);
                        minAccumulator.accumulate(e);
                    }));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(maxAccumulator.get() + " // " + minAccumulator.get());
    }
}
