package ru.mrchebik.task5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Task:
 *      Write a program that prints how many days you have been alive.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1999, 10, 3);

        System.out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));
    }
}
