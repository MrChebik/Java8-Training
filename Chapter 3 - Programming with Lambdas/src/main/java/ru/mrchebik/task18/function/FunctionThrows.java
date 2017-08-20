package ru.mrchebik.task18.function;

/**
 * Created by mrchebik on 8/20/17.
 */
@FunctionalInterface
public interface FunctionThrows<T, U> {
    U apply(T t) throws Exception;
}
