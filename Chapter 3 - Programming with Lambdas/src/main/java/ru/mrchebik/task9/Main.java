package ru.mrchebik.task9;

import ru.mrchebik.task9.person.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Task:
 *      Write a method 'lexicographicComparator(String... fieldNames)' that yields a comparator that compares the given
 *  fields in the given order. For example, a 'lexicographicComparator("lastname", "firstname")' takes two objects and,
 *  using reflection, gets the values of the 'lastname' field. If they are different, return the difference, otherwise
 *  move on to the 'firstname' field. If all fields match, return '0'.
 *
 * Created by mrchebik on 8/15/17.
 */
public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[] {
                new Person("William", "Stevens"),
                new Person("Natalie", "Price"),
                new Person("Lillian", "Arnold"),
                new Person("George", "Butler"),
                new Person("Kelley", "McCoy")
        };

        System.out.println(Arrays.toString(persons));
        Arrays.sort(persons, lexicographicComparator("firstname", "lastname"));
        System.out.println(Arrays.toString(persons));
        Arrays.sort(persons, lexicographicComparator("lastname", "firstname"));
        System.out.println(Arrays.toString(persons));
    }

    private static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (x, y) -> {
            for (String fieldName : fieldNames) {
                try {
                    Method method = x.getClass().getDeclaredMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
                    String valueX = (String) method.invoke(x);
                    String valueY = (String) method.invoke(y);

                    if (valueX == null && valueY == null) continue;
                    if (valueX == null || valueY == null) return valueX == null ? 1 : -1;

                    int compareResult = valueX.compareTo(valueY);
                    if (compareResult != 0) {
                        return compareResult;
                    }
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
                }
            }

            return 0;
        };
    }
}
