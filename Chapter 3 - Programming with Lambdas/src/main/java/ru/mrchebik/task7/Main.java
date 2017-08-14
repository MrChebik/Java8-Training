package ru.mrchebik.task7;

import ru.mrchebik.Utils;
import ru.mrchebik.task7.comparator.CustomComparator;

import java.util.Arrays;
import java.util.EnumSet;

import static ru.mrchebik.task7.comparator.CustomComparator.REVERSE;

/**
 * Task:
 *      Write a method that generates a `Comparator<String>` that can be normal or reversed, case-sensitive or
 *  case-insensitive or space-insensitive, or any combination thereof. Your method should return a lambda expression.
 *
 * Created by mrchebik on 8/14/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        String[] words = generateMassive(12, 5);

        System.out.println(Arrays.toString(words));

        Arrays.sort(words, CustomComparator.compare(EnumSet.of(REVERSE)));

        System.out.println(Arrays.toString(words));
    }
}
