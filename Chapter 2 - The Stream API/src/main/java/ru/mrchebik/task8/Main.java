package ru.mrchebik.task8;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Task:
 *      Write a method 'public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)' that alternates elements
 *  from the stream 'first' and 'second', stopping when one of them runs out of elements.
 *
 * Created by mrchebik on 8/3/17.
 */
public class Main {
    public static void main(String[] args) {
        zip(Stream.of(1, 3, 5, 7), Stream.of(2, 4, 6, 8)).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        first.forEach((e) -> {
            if (iterator.hasNext()) {
                builder.accept(e);
                builder.accept(iterator.next());
            } else {
                first.close();
            }
        });

        return builder.build();
    }
}
