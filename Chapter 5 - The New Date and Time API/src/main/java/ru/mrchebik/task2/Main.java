package ru.mrchebik.task2;

import java.time.LocalDate;

/**
 * Task:
 *      What happens when you add one year to 'LocalDate.of(2000, 2, 29)'? Four years ? Four times one year?
 *
 * Answer:
 *      'plusYears' check if the resulting date would be invalid and adjust the day-of-month to the last valid day if
 *  necessary.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        LocalDate initialDate = LocalDate.of(2000, 2, 29);

        System.out.println(initialDate.plusYears(1) +
                "\n--\n" +
                initialDate.plusYears(4) +
                "\n--\n" +
                initialDate.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}
