package ru.mrchebik.task7.time;

import java.time.LocalTime;

/**
 * Created by mrchebik on 8/26/17.
 */
public class TimeInterval {
    private LocalTime start;
    private LocalTime end;

    public TimeInterval(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlap(TimeInterval second) {
        return this.start.isAfter(second.start) && this.start.isBefore(second.end)
                || second.start.isAfter(this.start) && second.start.isBefore(this.end);
    }
}
