package ru.mrchebik.task2;

import ru.mrchebik.task2.person.Person;

/**
 * Task:
 *      Consider a class with many JavaFX properties, such as a chart or table. Chances are that in a particular
 *  application, most properties never have listeners attached to them. It is therefore wasteful to have a property
 *  object per property. Show how the property can be set up on demand, first using a regular field for storing the
 *  property value, and then using a property object only when the 'xxxProperty()' method is called for the first time.
 *
 * Created by mrchebik on 8/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe");

        person.getFirstName();
        person.getLastName();
        person.setFirstName("Jane");
        person.setLastName("Smith");
    }
}
