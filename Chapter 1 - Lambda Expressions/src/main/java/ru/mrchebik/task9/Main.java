package ru.mrchebik.task9;

import ru.mrchebik.Utils;
import ru.mrchebik.task9.model.ArrayList2;
import ru.mrchebik.task9.model.Collection2;

import java.util.Arrays;

/**
 * Task:
 *      Form a subclass 'Collection2' from 'Collection' and add a default method 'void forEachIf(Consumer<T> action,
 *  Predicate<T> filter)' that applies 'action' to each element for which 'filter' returns 'true'. How could you use it?
 *
 * Created by mrchebik on 7/25/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        Collection2<String> strings = new ArrayList2<>(Arrays.asList(generateMassive(100, 10)));
        strings.forEachIf(System.out::println, e -> e.length() == 5);
    }
}
