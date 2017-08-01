package ru.mrchebik;

import ru.mrchebik.exception.ExceptionUtils;

import java.util.Random;

/**
 * Created by mrchebik on 8/1/17.
 */
public class Utils extends ExceptionUtils {
    protected static String[] generateMassive(int lengthOfArray,
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
