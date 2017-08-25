package ru.mrchebik.task6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Task:
 *      List all Friday the 13th in the twentieth century.
 *
 * Created by mrchebik on 8/25/17.
 */
public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1901, 1, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        LocalDate end = LocalDate.of(2000, 12, 31);

        while (start.isBefore(end)) {
            if(start.getDayOfMonth() == 13) {
                System.out.println(start);
            }
            start = start.plusWeeks(1);
        }
    }
}
