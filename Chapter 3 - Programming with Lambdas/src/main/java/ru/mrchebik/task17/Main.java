package ru.mrchebik.task17;

import java.util.function.Consumer;

/**
 * Task:
 *      Implement a 'doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable>)' method that executes
 *  'first' and 'second' in parallel, calling the handler if either method throws an exception.
 *
 * Created by mrchebik on 8/20/17.
 */
public class Main {
    public static void main(String[] args) {
        doInParallelAsync(
                () -> {
                    if (System.currentTimeMillis() % 2 == 1) throw new RuntimeException("Exception in First");
                    else System.out.println("First OK");
                },
                () -> {
                    if (System.currentTimeMillis() % 2 == 2) throw new RuntimeException("Exception in Second");
                    else System.out.println("Second OK");
                },
                (t) -> System.out.println(t.getMessage())
        );
    }

    private static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        doInParallel(first, handler);
        doInParallel(second, handler);
    }

    private static void doInParallel(Runnable action, Consumer<Throwable> handler) {
        Thread t = new Thread(() -> {
            try {
                action.run();
            } catch (Throwable t1) {
                handler.accept(t1);
            }
        });
        t.start();
    }
}
