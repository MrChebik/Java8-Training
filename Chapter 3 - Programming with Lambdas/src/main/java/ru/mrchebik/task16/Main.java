package ru.mrchebik.task16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Task:
 *      Implement the 'doInOrderAsync' of Section 3.8, "Dealing with Exceptions", on page 58, where the second parameter
 *  is a 'BiConsumer<T, Throwable>'. Provide a plausible use case. Do you still need the third parameter?
 *
 * Created by mrchebik on 8/19/17.
 */
public class Main {
    public static void main(String[] args) {
        doInOrderAsync(
                () -> Integer.parseInt("a"),
                (i, e) -> {
                    if (i != null) {
                        System.out.printf("Parsed int: %d", i);
                    } else {
                        if (e instanceof NumberFormatException) {
                            System.out.printf("Couldn't parse, using defaults");
                        } else {
                            System.out.println("Something bad happened");
                        }
                    }
                }
        );
    }

    private static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread(() -> {
            try {
                T result = first.get();
                second.accept(result, null);
            } catch (Throwable t1) {
                second.accept(null, t1);
            }
        });
        t.start();
    }
}
