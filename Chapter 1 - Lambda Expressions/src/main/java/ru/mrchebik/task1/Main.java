package ru.mrchebik.task1;

import java.util.Arrays;
import java.util.Random;

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
public class Main {
    public static void main(String[] args) {
        String[] massive = generateMassive(100000, 10);
        System.out.println(Arrays.toString(massive));
        Arrays.sort(massive, String::compareTo);
        System.out.println(Arrays.toString(massive));
    }

    private static String[] generateMassive(int lengthOfArray,
                                            int maxLengthOfWord) {
        String[] words = new String[lengthOfArray];
        Random random = new Random();
        for (int i = 0; i < lengthOfArray; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < random.nextInt(maxLengthOfWord - 1) + 1; j++) {
                word.append((char) (random.nextInt(25) + 97));
            }
            words[i] = word.toString();
        }
        return words;
    }
}
