package ru.mrchebik.task23;

import ru.mrchebik.task23.pair.Pair;

/**
 * Task:
 *      Define a 'map' operation for a class 'Pair<T>' that represents a pair of objects of type 'T'.
 *
 * Created by mrchebik on 8/21/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Pair<>("1", "2").map(Integer::parseInt));
    }
}
