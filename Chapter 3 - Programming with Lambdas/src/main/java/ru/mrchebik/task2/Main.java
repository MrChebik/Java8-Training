package ru.mrchebik.task2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Task:
 *      When you use a 'ReentrantLock', you are required to lock and unlock with the idiom
 *
 *          myLock.lock();
 *          try {
 *              some action
 *          } finally {
 *              myLock.unlock();
 *          }
 *
 *  Provide a method 'withLock' so that one can call
 *
 *          withLock(myLock, () -> { some action })
 *
 *
 * Created by mrchebik on 8/13/17.
 */
public class Main {
    public static void main(String[] args) {
        withLock(new ReentrantLock(), () -> System.out.println("After lock of 'ReentrantLock', you see this message."));
    }

    private static void withLock(ReentrantLock myLock, Runnable action) {
        myLock.lock();
        try {
            action.run();
        } finally {
            myLock.unlock();
        }
    }
}
