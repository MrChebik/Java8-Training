package ru.mrchebik.directory;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by mrchebik on 7/23/17.
 */
public class Directory {
    public void getAllSubdirectories(String pathname) {
        checkDirectory(Paths.get(pathname).toFile());
    }

    private void checkDirectory(File pathname) {
        File[] directories = pathname.listFiles(File::isDirectory);

        if (directories != null) {
            for (File directory : directories) {
                System.out.println(directory.getPath());
                checkDirectory(directory);
            }
        }
    }
}
