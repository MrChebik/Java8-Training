package ru.mrchebik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrchebik on 7/25/17.
 */
public class Main {
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();

        // It is legal, 'name' is final and can't change.
        for (String name : names)
            runners.add(() -> System.out.println(name));

        // It is illegal, 'names[i]' is not final and can changes.
        /*for (int i = 0; i < names.length; i++)
            runners.add(() -> System.out.println(names[i]));*/

        // It is alternatively method :)
        /*for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }*/

        runners.forEach(Runnable::run);
    }
}
