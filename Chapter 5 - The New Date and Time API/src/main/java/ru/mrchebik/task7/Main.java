package ru.mrchebik.task7;


import ru.mrchebik.task7.time.TimeInterval;

import java.time.LocalTime;

/**
 * Task:
 *      Implement a 'TimeInterval' class that represents an interval of time, suitable for calendar events (such as a
 *  meeting on a given date from 10:00 to 11:00). Provide a method to check whether two intervals overlap.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        TimeInterval first = new TimeInterval(
                LocalTime.of(10, 0),
                LocalTime.of(12, 0));
        TimeInterval second = new TimeInterval(
                LocalTime.of(11, 30),
                LocalTime.of(14, 0));
        TimeInterval third = new TimeInterval(
                LocalTime.of(9, 0),
                LocalTime.of(11, 0));

        System.out.println(first.overlap(second));
        System.out.println(third.overlap(second));
    }
}
