package ru.mrchebik.task7.comparator;

import java.util.Comparator;
import java.util.EnumSet;

/**
 * Created by mrchebik on 8/14/17.
 */
public enum CustomComparator {
    REVERSE,
    IGNORE_CASE,
    IGNORE_SPACE;

    public static Comparator<String> compare(EnumSet<CustomComparator> options) {
        return (x, y) -> {
            if (options.contains(IGNORE_CASE)) {
                x = x.toLowerCase();
                y = y.toLowerCase();
            }
            if (options.contains(IGNORE_SPACE)) {
                x = x.replaceAll("\\s+", "");
                y = y.replaceAll("\\s+", "");
            }
            return options.contains(REVERSE) ? y.compareTo(x) : x.compareTo(y);
        };
    }
}
