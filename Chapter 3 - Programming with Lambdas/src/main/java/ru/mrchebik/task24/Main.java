package ru.mrchebik.task24;

import ru.mrchebik.task24.pair.Pair;

/**
 * Task:
 *      Can you define a 'flatMap' method for 'Pair<T>'? If so, what is it? If not, why not?
 *
 * Answer:
 *      We can do this, with 'BiFunction<T, T, U>'.
 *
 * Created by mrchebik on 8/22/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Pair<>("1", "2").flatMap((a, b) -> new Pair<>(Integer.parseInt(a), Integer.parseInt(b))));
    }
}
