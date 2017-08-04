package ru.mrchebik.task12;

import ru.mrchebik.Utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Task:
 *      Count all short words in a parallel 'Stream<String>', as described in Section 2.13, "Parallel Streams", on page
 *  40, by updating an array of 'AtomicInteger'. Use the atomic `getAndIncrement` method to safely increment each
 *  counter.
 *
 * Created by mrchebik on 8/4/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        AtomicInteger[] shortWords = IntStream.range(0, 12).mapToObj(i -> new AtomicInteger(0)).toArray(AtomicInteger[]::new);

        Stream.of(generateMassive(1000, 20)).parallel().forEach(word -> {
            if (word.length() < 12) {
                shortWords[word.length()].getAndIncrement();
            }
        });

        Stream.of(shortWords).forEach(System.out::println);
    }
}
