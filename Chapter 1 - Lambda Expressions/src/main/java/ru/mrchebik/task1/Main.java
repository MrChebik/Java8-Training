package ru.mrchebik.task1;

import ru.mrchebik.Utils;

import java.util.Arrays;

/**
 * Task:
 *      Is the comparator code in the 'Arrays.sort' method called in the same thread as the call to 'sort' or a
 *  different thread?
 *
 * Answer:
 *      The code at the lambda block executes at the same thread.
 *
 * Created by mrchebik on 7/23/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        String[] massive = generateMassive(100000, 10);
        System.out.println(Arrays.toString(massive));
        Arrays.sort(massive, String::compareTo);
        System.out.println(Arrays.toString(massive));
    }
}
