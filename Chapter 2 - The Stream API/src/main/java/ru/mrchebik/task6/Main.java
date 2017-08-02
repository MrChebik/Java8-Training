package ru.mrchebik.task6;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Task:
 *      The 'characterStream' method in Section 2.3, "The 'filter', 'map', and 'flatMap' Methods", on page 25, was a bit
 *  clumsy, first filling an array list and then turning it into a stream. Write a stream-based one-linear instead. One
 *  approach is to make a stream of integers from '0' to 's.length()' - '1' and map that with the 's::charAt' method
 *  reference.
 *
 * Created by mrchebik on 8/2/17.
 */
public class Main {
    public static void main(String[] args) {
        characterStream("Hello World!").forEach(System.out::println);
    }

    private static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
