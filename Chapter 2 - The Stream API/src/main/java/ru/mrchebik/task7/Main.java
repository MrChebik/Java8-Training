package ru.mrchebik.task7;

import ru.mrchebik.Utils;

import java.util.stream.Stream;

/**
 * Task:
 *      Your manager asks you to write a method 'public static <T> boolean isFinite(Stream<T> stream)'. Why isn't that
 *  such a good idea? Go ahead and write it anyway.
 *
 * Answer:
 *      - If 'Stream' is infinite, that method will be work indefinitely.
 *      - This method should use terminal operation.
 *
 * Created by mrchebik on 8/3/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        System.out.println(isFinite(Stream.of(generateMassive(1000, 24))));
        System.out.println(isFinite(Stream.generate(() -> 1)));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.count() <= Long.MAX_VALUE;
    }
}
