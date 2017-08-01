package ru.mrchebik.exception.service;

/**
 * Created by mrchebik on 7/31/17.
 */
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}