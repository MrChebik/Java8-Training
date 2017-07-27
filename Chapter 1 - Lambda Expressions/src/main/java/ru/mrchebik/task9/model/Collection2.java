package ru.mrchebik.task9.model;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by mrchebik on 7/25/17.
 */
public interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        forEach(e -> {
            if (filter.test(e)) {
                action.accept(e);
            }
        });
    }
}
