package ru.mrchebik.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * Task:
 *      What happens when a lambda expression captures values in an enhanced for loop such as this one?
 *
 *          String[] names = { "Peter", "Paul", "Mary" };
 *          List<Runnable> runners = new ArrayList<>();
 *          for (String name : names)
 *              runners.add(() -> System.out.println(name));
 *
 *  Is it legal? Does each lambda expression capture a different value or do they all get the last value? What happens
 *  if you use a traditional loop 'for (int i = 0; i < names.length; i++)'?
 *
 * Answer:
 *      It is legal, 'name' is final and can't change. When we use traditional loop, it is illegal, 'names[i]' is not
 *  final and can changes.
 *
 * Created by mrchebik on 7/25/17.
 */
public class Main {
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();

        for (String name : names)
            runners.add(() -> System.out.println(name));

        runners.forEach(Runnable::run);
    }
}
