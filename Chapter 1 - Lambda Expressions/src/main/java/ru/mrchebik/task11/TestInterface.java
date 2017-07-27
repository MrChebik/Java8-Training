package ru.mrchebik.task11;

import ru.mrchebik.task11.model.I;
import ru.mrchebik.task11.model.J;

/**
 * Task:
 *      Suppose you have a class that implements two interfaces 'I' and 'J', each of which has a method 'void f()'.
 *  Exactly, what happens if 'f' is an abstract, default, or static method of 'I' and an abstract, default or static
 *  method of 'J'?
 *
 * Answer:
 *      You must override 'fDefault', if 'I' and 'J' implements in your class.
 *      You can't run 'fStatic' method.
 *
 * Created by mrchebik on 7/27/17.
 */
public class TestInterface implements I, J {
    public static void main(String[] args) {
        // Interface
        I.fStatic();
        J.fStatic();

        ((I) () -> System.out.println("Must be overridden.")).fDefault();
        ((J) () -> System.out.println("Must be overridden.")).fDefault();

        // Instance
        TestInterface test = new TestInterface();
        test.f();
        test.fDefault();
    }

    @Override
    public void f() {
        System.out.println("TestInterface -- 'void'");
    }

    @Override
    public void fDefault() {
        System.out.println("TestInterface -- 'default'");
    }
}
