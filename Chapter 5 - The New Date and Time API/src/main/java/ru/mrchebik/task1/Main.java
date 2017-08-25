package ru.mrchebik.task1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Task:
 *      Compute Programmer's Day without using 'plusDays'.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDate.of(2017, Month.JANUARY, 1).plus(Period.ofDays(255)));
    }
}
