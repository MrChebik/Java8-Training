package ru.mrchebik.task11;

import ru.mrchebik.task11.model.I;
import ru.mrchebik.task11.model.S;

/**
 * Task:
 *      Repeat where a class extends a superclass 'S' and implements an interface 'I', each of which has a method
 *  'void f()'.
 *
 * Answer:
 *      'S' override 'fStatic' from 'I'.
 *
 * Created by mrchebik on 7/27/17.
 */
public class TestWithClass extends S implements I {
    public static void main(String[] args) {
        TestWithClass withClass = new TestWithClass();
        withClass.f();
        withClass.fDefault();
        TestWithClass.fStatic();
    }

    @Override
    public void f() {
        System.out.println("TestWithClass -- 'void'");
    }
}
