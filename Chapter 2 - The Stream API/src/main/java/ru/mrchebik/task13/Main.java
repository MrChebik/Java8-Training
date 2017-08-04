package ru.mrchebik.task13;

import ru.mrchebik.Utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task:
 *      Repeat the preceding exercise, but filter out the short strings and use the 'collect' method with
 *  'Collectors.groupingBy' and 'Collectors.counting'.
 *
 * Created by mrchebik on 8/4/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        Stream.of(generateMassive(1000, 20)).parallel()
                .filter(word -> word.length() < 12)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .forEach((length, count) -> System.out.println(count));
    }
}
