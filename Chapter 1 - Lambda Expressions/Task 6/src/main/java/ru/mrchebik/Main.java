package ru.mrchebik;

import ru.mrchebik.runnable.RunnableEx;

import java.util.concurrent.Callable;

/**
 * Created by mrchebik on 7/25/17.
 */
public class Main {
    // Can't use Callable<Void> because it required 'return null;' to the lambda expression.
    public static void main(String[] args) {
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
    }

    private static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {
            try {
                runnableEx.run();
            } catch (Exception ignored) {
            }
        };
    }

    /* The code with Callable<Void>

    public static void main(String[] args) {
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000); return null; })).start();
    }

    private static Runnable uncheck(Callable<Void> runnableEx) {
        return () -> {
            try {
                runnableEx.call();
            } catch (Exception ignored) {
            }
        };
    }
     */
}