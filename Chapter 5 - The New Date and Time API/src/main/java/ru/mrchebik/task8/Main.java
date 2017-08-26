package ru.mrchebik.task8;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Task:
 *      Obtain the offsets of today's date in all supported time zoned for the current time instant, turning
 *  'ZoneId.getAvailableIds' into a stream and using stream operations.
 *
 * Created by mrchebik on 8/26/17.
 */
public class Main {
    public static void main(String[] args) {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(id -> now.atZone(ZoneId.of(id)).getOffset())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
