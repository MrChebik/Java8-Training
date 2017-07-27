package ru.mrchebik.task4.directory;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by mrchebik on 7/24/17.
 */
public class Directory {
    public static void sortAllFiles(String pathname) {
        File[] files = Paths.get(pathname).toFile().listFiles();

        if (files != null) {
            Arrays.sort(files, (file0, file1) -> {
                if (file0.isDirectory() || file1.isDirectory()) {
                    return file0.isDirectory() && !file1.isDirectory() ? -1 : 1;
                } else {
                    return file0.getName().compareToIgnoreCase(file1.getName());
                }
            });
        }

        System.out.println(Arrays.toString(files));
    }
}
