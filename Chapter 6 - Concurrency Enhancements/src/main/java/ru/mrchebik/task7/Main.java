package ru.mrchebik.task7;

import ru.mrchebik.Utils;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Task:
 *      In a 'ConcurrentHashMap<String, Long>', find the key with maximum value (breaking ties arbitrarily). Hint:
 *  `reduceEntries`.
 *
 * Created by mrchebik on 9/1/17.
 */
public class Main extends Utils {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        Arrays.stream(generateMassive(1000, 10)).forEach(w -> map.computeIfAbsent(w, k -> (long) k.length()));
        Map.Entry<String, Long> entry = map.reduceEntries(8, (v1, v2) ->
                v1.getValue() > v2.getValue() ? v1 : v2);

        System.out.println(entry.getKey());
    }
}
