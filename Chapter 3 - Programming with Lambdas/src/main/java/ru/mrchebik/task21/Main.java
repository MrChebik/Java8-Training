package ru.mrchebik.task21;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Task:
 *      Supply a static method '<T, U> Future<U> map(Future<T>, Function<T, U>)'. Return an object of an anonymous class
 *  that implements all methods of the 'Future' interface. In the 'get' methods, invoke the function.
 *
 * Created by mrchebik on 8/21/17.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(map(Executors.newCachedThreadPool().submit(() -> "1"), Integer::parseInt).get());
    }

    private static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
        return new Future<U>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return future.cancel(mayInterruptIfRunning);
            }

            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override
            public boolean isDone() {
                return future.isDone();
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return function.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return function.apply(future.get(timeout, unit));
            }
        };
    }
}
