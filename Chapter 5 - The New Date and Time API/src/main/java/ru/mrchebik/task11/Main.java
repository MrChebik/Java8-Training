package ru.mrchebik.task11;

import java.time.*;

/**
 * Task:
 *      Your return flight leaves Frankfurt at 14:05 and arrives in Los Angeles at 16:40. How long is the flight? Write
 *  a program that can handle calculations like this.
 *
 * Created by mrchebik on 8/27/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getDuration(
                LocalTime.of(14, 5),
                ZoneId.of("Europe/Paris"),
                LocalTime.of(16, 40),
                ZoneId.of("America/Los_Angeles")
        ));
    }

    private static Duration getDuration(LocalTime departure,
                                ZoneId departureZone,
                                LocalTime arrival,
                                ZoneId arrivalZone) {
        LocalDate now = LocalDate.now();
        Instant departuteInstant = ZonedDateTime.of(
                now,
                departure,
                departureZone
        ).toInstant();
        Instant arrivalInstant = ZonedDateTime.of(
                (arrival.isBefore(departure) || arrival.equals(departure)) ? now.plusDays(1) : now,
                arrival,
                arrivalZone
        ).toInstant();
        return Duration.between(departuteInstant, arrivalInstant);
    }
}
