package ru.mrchebik.task3.extension;

import java.nio.file.Paths;

/**
 * Created by mrchebik on 7/24/17.
 */
public class Extension {
    public static void getAllFiles(String pathname,
                                   String extension) {
        String[] files = Paths.get(pathname).toFile().list(((dir, name) -> name.endsWith("." + extension)));

        assert files != null;
        for (String file : files) {
            System.out.println(file);
        }
    }
}
