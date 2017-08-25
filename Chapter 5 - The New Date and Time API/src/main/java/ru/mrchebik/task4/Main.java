package ru.mrchebik.task4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Task:
 *      Write an equivalent of the Unix `cal` program that displays a calendar for a month. For example,
 *  'java Cal 3 2013' should display
 *
 *                        1  2  3
 *            4  5  6  7  8  9 10
 *           11 12 13 14 15 16 17
 *           18 19 20 21 22 23 24
 *           25 26 27 28 29 30 31
 *
 *  indicating that March 1 is a Friday. (Show the weekend at the end of the week.)
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        if (month > 12) {
            int temp = month;
            month = year;
            year = temp;
        }

        LocalDate localDate = LocalDate.of(year, month, 1);

        if (localDate.getDayOfWeek() != DayOfWeek.MONDAY) {
            localDate = localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }

        while (localDate.getMonth().getValue() < month + 1) {
            System.out.print(getDay(localDate, month));
            if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY
                    && localDate.plusDays(1).getMonth().getValue() < month + 1) {
                System.out.println("");
            }
            localDate = localDate.plusDays(1);
        }
    }

    private static String getDay(LocalDate date, int month) {
        if (date.getMonth().getValue() != month) {
            return "    ";
        }

        return date.getDayOfMonth() < 10
                ? "   " + date.getDayOfMonth()
                : "  " + date.getDayOfMonth();
    }
}
