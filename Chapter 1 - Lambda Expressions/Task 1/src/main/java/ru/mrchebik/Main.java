package ru.mrchebik;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrchebik on 7/23/17.
 */
public class Main {
    public static void main(String[] args) {
        String[] massive = generateMassive(100000, 10);
        System.out.println(Arrays.toString(massive));
        Arrays.sort(massive, String::compareTo);
        System.out.println(Arrays.toString(massive));
    }

    private static String[] generateMassive(int lengthOfArray, int maxLengthOfWord) {
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
