package ru.mrchebik.task3;

import java.time.LocalDate;

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * Task:
 *      Implement a method `next` that takes a `Predicate<LocalDate>` and returns an adjuster yielding the next date
 *  fulfilling the predicate. For example,
 *
 *          today.with(next(w -> getDayOfWeek().getValue() < 6))
 *
 *  computes the next workday.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        System.out.println(now + " // " + now.with(next(w -> w.getDayOfWeek().getValue() < 6)));
    }

    public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(temporal -> {
            LocalDate date = temporal;
            do {
                date = date.plusDays(1);
            } while (!predicate.test(date));
            return date;
        });
    }
}
