package ru.mrchebik.task6;

import ru.mrchebik.task6.runnable.RunnableEx;

/**
 * Task:
 *      Didn't you always hate it that you had to deal with checked exceptions in a 'Runnable'? Write a method 'uncheck'
 *  that catches all checked exceptions and turns them into unchecked exceptions. For example,
 *
 *      new Thread(uncheck(
 *          () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
 *              // Look, no catch (InterruptedException)!
 *
 *  Hint: Define an interface 'RunnableEx' whose run method may throw any exceptions. Then implement 'public static
 *  Runnable uncheck(RunnableEx runner)'. Use a lambda expression inside the 'uncheck' function.
 *
 *  Why can't you just use 'Callable<Void>' instead of 'RunnableEx'?
 *
 * Answer:
 *      Can't use 'Callable<Void>' because it required 'return null;' to the lambda expression.
 *
 * Created by mrchebik on 7/25/17.
 */
public class Main {
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

    // The code with 'Callable<Void>'
    /*public static void main(String[] args) {
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
    }*/
}