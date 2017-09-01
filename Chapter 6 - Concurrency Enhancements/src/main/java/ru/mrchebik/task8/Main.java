package ru.mrchebik.task8;

import ru.mrchebik.Utils;

import java.util.Arrays;

/**
 * Task:
 *      How large does an array have to be for `Arrays.parallelSort` to be faster that `Arrays.sort` on your computer?
 *
 * Created by mrchebik on 9/1/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        String[] wordsParallel = generateMassive(1_000_000, 20);
        String[] wordsCommon = Arrays.stream(wordsParallel).toArray(String[]::new);

        long startP = System.currentTimeMillis();

        Arrays.parallelSort(wordsParallel);

        long endP = System.currentTimeMillis();

        long startC = System.currentTimeMillis();

        Arrays.sort(wordsCommon);

        long endC = System.currentTimeMillis();

        System.out.println((endP - startP) + " // " + (endC - startC));
    }
}
