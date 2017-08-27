package ru.mrchebik.task10;

import java.time.*;

/**
 * Task:
 *      Your flight from Los Angeles to Frankfurt leaves at 3:05 pm local time and takes 10 hours and 50 minutes. When
 *  does it arrive? Write a program that can handle calculations like this.
 *
 * Created by mrchebik on 8/26/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getArrivalTime(
                LocalTime.of(15, 5),
                ZoneId.of("America/Los_Angeles"),
                Duration.ofMinutes(10 * 60 + 50),
                ZoneId.of("Europe/Paris")
        ));
    }

    private static LocalTime getArrivalTime(LocalTime departure,
                                            ZoneId location,
                                            Duration duration,
                                            ZoneId destination) {
        ZonedDateTime departureDateTime = ZonedDateTime.of(
                LocalDate.now(),
                departure,
                location
        );
        ZonedDateTime arrivalDateTime = departureDateTime.plus(duration);
        return arrivalDateTime.withZoneSameInstant(destination).toLocalTime();
    }
}
