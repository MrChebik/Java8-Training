package ru.mrchebik.task3;

import java.util.function.BooleanSupplier;

/**
 * Task:
 *      Java 1.4 added assertions to the language, with an `assert` keyword. Why were assertions not supplied as a
 *  library feature? Could they be implemented as a library feature in Java 8?
 *
 * Created by mrchebik on 8/13/17.
 */
public class Main {
    public static void main(String[] args) {
        assertThat(() -> 2 + 2 != 4);
    }

    private static void assertThat(BooleanSupplier assertion) {
        if (!assertion.getAsBoolean()) {
            throw new AssertionError();
        }
    }
}
