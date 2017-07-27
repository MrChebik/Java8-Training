package ru.mrchebik.task11.model;

/**
 * Created by mrchebik on 7/27/17.
 */
public interface J {
    void f();

    default void fDefault() {
        System.out.println("J -- 'default'");
    }

    static void fStatic() {
        System.out.println("J -- 'static'");
    }
}
