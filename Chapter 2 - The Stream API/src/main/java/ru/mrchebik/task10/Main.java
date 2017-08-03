package ru.mrchebik.task10;

import ru.mrchebik.task10.math.AverageStream;

import java.util.stream.Stream;

/**
 * Task:
 *      Write a call to 'reduce' that can be used to compute the average of a 'Stream<Double>'. Why can't you simply
 * compute the sum and divide by 'count()'?
 *
 * Answer:
 *      We can't do this, because 'sum' and 'divide' is terminal operations.
 *
 * Created by mrchebik on 8/3/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(average(Stream.of(3.23, 6.1, 1.7, 7.468)));
    }

    private static double average(Stream<Double> stream) {
        return stream.reduce(new AverageStream(), AverageStream::accept, AverageStream::combine).average();
    }
}
