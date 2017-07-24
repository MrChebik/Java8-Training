package ru.mrchebik.extension;

import java.nio.file.Paths;

/**
 * Created by mrchebik on 7/24/17.
 */
public class Extension {
    public static void getAllFiles(String pathname, String extension) {
        // That capture:
        // File  : Paths.get(pathname).toFile()
        // String: From 'Paths.get(pathname).toFile().list()', goes through all the elements of the String[]
        String[] files = Paths.get(pathname).toFile().list(((dir, name) -> name.endsWith("." + extension)));

        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
