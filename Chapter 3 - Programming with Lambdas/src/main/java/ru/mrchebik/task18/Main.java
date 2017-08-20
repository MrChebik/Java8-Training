package ru.mrchebik.task18;

import ru.mrchebik.task18.function.FunctionThrows;

import java.util.function.Function;

/**
 * Task:
 *      Implement a version of the 'unchecked' method in Section 3.8, "Dealing with Exceptions", on page 58, that
 *  generates a 'Function<T, U>' from a lambda that throws checked exceptions. Note that you will need to find or
 *  provide a functional interface whose abstract method throws arbitrary exceptions.
 *
 * Created by mrchebik on 8/20/17.
 */
public class Main {
    public static void main(String[] args) {
        unchecked(arg -> {
            throw new Exception("Custom exception.");
        }).apply("abc");
    }

    public static <T, U> Function<T, U> unchecked(FunctionThrows<T, U> f) {
        return arg -> {
            try {
                return f.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
