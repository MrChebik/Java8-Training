package ru.mrchebik.task12;

import java.time.*;

/**
 * Task:
 *      Write a program that solves the problem described at the beginning of Section 5.5, "Zoned Time", on page 109.
 *  Read a set of appointments in different time zones and alert the User which ones are due within the next hour in
 *  local time.
 *
 * Created by mrchebik on 8/27/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(alert(
                LocalTime.of(1, 40), ZoneId.of("America/Los_Angeles"),
                LocalTime.of(9, 50), ZoneId.of("Europe/Paris")));
    }

    private static boolean alert(LocalTime appointmentTime,
                                 ZoneId appointmentZone,
                                 LocalTime localTime,
                                 ZoneId localZone) {
        ZonedDateTime appointment = ZonedDateTime.of(
                LocalDate.now(),
                appointmentTime,
                appointmentZone
        );
        long duration = Duration.between(
                ZonedDateTime.of(LocalDate.now(), localTime, localZone).toInstant(),
                appointment.withZoneSameInstant(localZone).toInstant())
                .toMinutes();

        return 0 < duration && duration < 60;
    }
}
