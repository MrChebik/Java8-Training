package ru.mrchebik.task5;

import java.util.stream.Stream;

/**
 * Task:
 *      Using 'Stream.iterate', make an infinite stream of random numbers — not by calling 'Math.random' but by directly
 *  implementing a 'linear congruential generator'. In such a generator, you start with x[0] = seed and then produce
 *  x[n + 1] = 1 (a x[n] + c) % m, for appropriate values of a, c, and m. You should implement a method with parameters
 *  'a', 'c', 'm', and 'seed' that yields a 'Stream<Long>'. Try out a = 25214903917, c = 11, and m = 2^48.
 *
 * Created by mrchebik on 8/2/17.
 */
public class Main {
    public static void main(String[] args) {
        generateRandom(25214903917L, 11, (long) Math.pow(2, 48), System.currentTimeMillis())
                .limit(10).forEach(System.out::println);
    }

    private static Stream<Long> generateRandom(long a,
                                               long c,
                                               long m,
                                               long seed) {
        return Stream.iterate(seed, number -> (a * number + c) % m);
    }
}
