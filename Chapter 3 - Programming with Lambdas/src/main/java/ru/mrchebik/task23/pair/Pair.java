package ru.mrchebik.task23.pair;

import java.util.function.Function;

/**
 * Created by mrchebik on 8/21/17.
 */
public class Pair<T> {
    public T first;
    public T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
        return new Pair<>(mapper.apply(first), mapper.apply(second));
    }

    @Override
    public String toString() {
        return first.getClass() + " : " + first + " " + second;
    }
}
