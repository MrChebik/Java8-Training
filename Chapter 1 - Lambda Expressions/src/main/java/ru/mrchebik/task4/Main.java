package ru.mrchebik.task4;

import ru.mrchebik.task4.directory.Directory;

/**
 * Task:
 *      Given an array of 'File' objects, sort it so that directories come before the files, and within each group,
 *  elements are sorted by path name, Use a lambda expression, not a 'Comparator'.
 *
 * Created by mrchebik on 7/24/17.
 */
public class Main {
    public static void main(String[] args) {
        Directory.sortAllFiles("/home/mrchebik/idea-IU-171.4424.56");
    }
}
