package ru.mrchebik.task24.pair;

import java.util.function.BiFunction;

/**
 * Created by mrchebik on 8/22/17.
 */
public class Pair<T> {
    public T first;
    public T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public <U> Pair<U> flatMap(BiFunction<? super T, ? super T, Pair<U>> mapper) {
        return mapper.apply(first, second);
    }

    @Override
    public String toString() {
        return first.getClass() + " : " + first + " " + second;
    }
}
