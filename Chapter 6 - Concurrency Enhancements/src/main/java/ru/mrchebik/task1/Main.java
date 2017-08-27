package ru.mrchebik.task1;

import ru.mrchebik.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Task:
 *      Write a program that keeps track of the longest string that is observed by a number of threads. Use an
 *  'AtomicReference' and an appropriate accumulator.
 *
 * Created by mrchebik on 8/28/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        AtomicReference<String> longest = new AtomicReference<>();
        LongAccumulator accumulator = new LongAccumulator(Long::max, 0);
        List<String> words = Arrays.asList(Utils.generateMassive(1000, 25));

        words.parallelStream().forEach(element -> longest.updateAndGet(
                current -> {
                    String result = element.length() > accumulator.intValue() ? element : current;
                    accumulator.accumulate(result.length());

                    return result;
                }));

        System.out.println(longest.get());
    }
}
