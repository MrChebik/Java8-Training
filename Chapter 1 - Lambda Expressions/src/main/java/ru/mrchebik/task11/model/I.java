package ru.mrchebik.task11.model;

/**
 * Created by mrchebik on 7/27/17.
 */
public interface I {
    void f();

    default void fDefault() {
        System.out.println("I -- 'default'");
    }

    static void fStatic() {
        System.out.println("I -- 'static'");
    }
}
