package ru.mrchebik;

import ru.mrchebik.model.ArrayList2;
import ru.mrchebik.model.Collection2;

import java.util.Arrays;

/**
 * Created by mrchebik on 7/25/17.
 */
public class Main {
    public static void main(String[] args) {
        Collection2<String> strings = new ArrayList2<>(Arrays.asList("a", "ab", "abc", "as", "ew", "hy"));
        strings.forEachIf(System.out::println, e -> e.length() == 2);
    }
}
