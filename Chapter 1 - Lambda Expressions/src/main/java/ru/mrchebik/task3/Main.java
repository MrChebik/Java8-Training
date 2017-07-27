package ru.mrchebik.task3;


import ru.mrchebik.task3.extension.Extension;

/**
 * Task:
 *      Using the 'list(FilenameFilter)' method of the 'java.io.File' class, write a method that returns all files in a
 *  given directory with a given extension. Use a lambda expression, not a 'FilenameFilter'. Which variables from the
 *  enclosing scope does it capture?
 *
 * Answer:
 *      File  : 'Paths.get(pathname).toFile()'
 *      String: From 'Paths.get(pathname).toFile().list()', goes through all the elements of the 'String[]'
 *
 * Created by mrchebik on 7/24/17.
 */
public class Main {
    public static void main(String[] args) {
        Extension.getAllFiles("/home/mrchebik/idea-IU-171.4424.56/bin", "sh");
    }
}
