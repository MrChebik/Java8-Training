package ru.mrchebik.task2;

import ru.mrchebik.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task:
 *      Verify that asking for the first five long words does not call the filter method once the fifth long word has
 *  been found. Simply log each method call.
 *
 * Created by mrchebik on 8/1/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList(generateMassive(100, 24)));
        words.stream().filter(w -> w.length() > 12).limit(5).forEach(System.out::println);
    }
}
