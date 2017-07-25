package ru.mrchebik;

/**
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
