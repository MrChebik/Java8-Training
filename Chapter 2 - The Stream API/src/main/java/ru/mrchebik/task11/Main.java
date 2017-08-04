package ru.mrchebik.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Task:
 *      It should be possible to concurrently collect stream results in a single 'ArrayList', instead of merging
 *  multiple array lists, provided it has been constructed with the stream's size, since concurrent 'set' operations at
 *  disjoint positions are threadsafe. How can you achieve this?
 *
 * Created by mrchebik on 8/4/17.
 */
public class Main {
    public static void main(String[] args) {
        List<ArrayList<Integer>> oddNumbers = new ArrayList<>();
        oddNumbers.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
        oddNumbers.add(new ArrayList<>(Arrays.asList(11, 13, 15, 17, 19)));
        oddNumbers.add(new ArrayList<>(Arrays.asList(21, 23, 25, 27, 29)));

        System.out.println(collect(oddNumbers.stream()));
    }

    private static List<Integer> collect(Stream<ArrayList<Integer>> stream) {
        Integer[] array = stream.flatMap(Collection::stream).toArray(Integer[]::new);
        IntStream range = IntStream.range(0, array.length);
        List<Integer> result = new ArrayList<>(Arrays.asList(new Integer[array.length]));
        range.parallel().forEach(e -> result.set(e, array[e]));

        return result;
    }
}
