package ru.mrchebik.task2;

import ru.mrchebik.task2.directory.Directory;

/**
 * Task:
 *      Using the 'listFiles(FileFilter)' and 'isDirectory' methods of the 'java.io.File' class, write a method that
 *  returns all subdirectories of a given directory. Use a lambda expression instead of a 'FileFilter' object. Repeat
 *  with a method expression.
 *
 * Created by mrchebik on 7/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Directory.getAllSubdirectories("/home/mrchebik/idea-IU-171.4424.56/plugins");
    }
}
