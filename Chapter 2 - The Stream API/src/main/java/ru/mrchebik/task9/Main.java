package ru.mrchebik.task9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Task:
 *      Join all elements in a 'Stream<ArrayList<T>>' to one 'ArrayList<T>'. Show how to do this with the three forms of
 *  'reduce'.
 *
 * Created by mrchebik on 8/3/17.
 */
public class Main {
    public static void main(String[] args) {
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("a", "b", "c", "d")));
        list.add(new ArrayList<>(Arrays.asList("ab", "cd", "ef", "gh")));
        System.out.println(joinToArrayList(list.stream()));
        System.out.println(joinWithReduceToArrayList0(list.stream()).get());
        System.out.println(joinWithReduceToArrayList1(list.stream()));
        System.out.println(joinWithReduceToArrayList2(list.stream()));
    }

    private static <T> List<T> joinToArrayList(Stream<ArrayList<T>> stream) {
        return stream.flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static <T> Optional<ArrayList<T>> joinWithReduceToArrayList0(Stream<ArrayList<T>> stream) {
        return stream.reduce((list1, list2) -> {
            ArrayList<T> result = new ArrayList<>(list1);

            result.addAll(list2);

            return result;
        });
    }

    private static <T> List<T> joinWithReduceToArrayList1(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (acc, e) -> {
            acc.addAll(e);
            return acc;
        });
    }

    public static <T> List<T> joinWithReduceToArrayList2(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(),
                (acc, e) -> {
                    acc.addAll(e);
                    return acc;
                },
                (e1, e2) -> {
                    e1.addAll(e2);
                    return e1;
                }
        );
    }
}
