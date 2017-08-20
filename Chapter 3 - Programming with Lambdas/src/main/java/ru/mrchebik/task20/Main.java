package ru.mrchebik.task20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Task:
 *      Supply a static method '<T, U> List<U> map(List<T>, Function<T, U>)'.
 *
 * Created by mrchebik on 8/20/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(map(Arrays.asList("1", "2", "3", "4", "5"), Integer::parseInt));
    }

    private static <T, U> List<U> map(List<T> list, Function<T, U> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
