package ru.mrchebik.task7;

/**
 * Task:
 *      Write a static method 'andThen' that takes as parameters two 'Runnable' instances and returns a 'Runnable' that
 *  runs the first, then the second. In the 'main' method, pass two lambda expressions into a call to 'andThen', and run
 *  the returned instance.
 *
 * Created by mrchebik on 7/25/17.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(andThen(
                () -> System.out.println("first"),
                () -> System.out.println("second")
        )).start();
    }

    private static Runnable andThen(Runnable first,
                                    Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
