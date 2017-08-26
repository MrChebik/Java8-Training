package ru.mrchebik.task9;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Task:
 *      Again using stream operations, find all time zones whose offsets aren't full hours.
 *
 * Created by mrchebik on 8/26/17.
 */
public class Main {
    public static void main(String[] args) {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(id -> now.atZone(ZoneId.of(id)).getOffset())
                .filter(o -> o.getTotalSeconds() % 3600 != 0)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
