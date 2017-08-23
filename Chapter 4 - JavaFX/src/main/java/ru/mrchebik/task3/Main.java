package ru.mrchebik.task3;

import ru.mrchebik.task3.person.Person;

/**
 * Task:
 *      Consider a class with many JavaFX properties, most of which are never changed from a default. Show how the
 *  property can be set up on demand, when it is set to a nondefault value or when the 'xxxProperty()' method is called
 *  for the first time.
 *
 * Created by mrchebik on 8/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Person john = new Person();
        System.out.println(john.firstName);
        System.out.println(john.lastName);
        john.setFirstName("John");
        System.out.println(john.firstName);
        john.setLastName("Black");
        System.out.println(john.lastName);
        john.setFirstName("Johan");
        System.out.println(john.firstName);
        john.setLastName("White");
        System.out.println(john.lastName);
        Person doug = new Person("Doug", "Green");
        System.out.println(doug.firstName);
        System.out.println(doug.lastName);
    }
}
