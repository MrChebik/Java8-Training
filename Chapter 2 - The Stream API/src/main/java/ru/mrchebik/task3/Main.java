package ru.mrchebik.task3;

import ru.mrchebik.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Task:
 *      Measure the difference when counting long words with a 'parallelStream' instead of a 'stream'. Call
 *  'System.currentTimeMillis' before and after the call, and print the difference. Switch to a larger document (such as
 *  _War and Peace_) if you have a fast computer.
 *
 * Created by mrchebik on 8/1/17.
 */
public class Main extends Utils {
    private static final String PATH_TO_WAR_AND_PEACE = "/home/mrchebik/Documents/war-and-peace";

    public static void main(String[] args) throws IOException {
        File file = new File(PATH_TO_WAR_AND_PEACE);
        long start;
        long startParallel;
        long end;
        long endParallel;

        if (!file.exists()) {
            start = System.currentTimeMillis();
            Stream.of(generateMassive(1000, 24)).filter(word -> word.length() > 12);
            end = System.currentTimeMillis() - start;

            startParallel = System.currentTimeMillis();
            Stream.of(generateMassive(1000, 24)).parallel().filter(word -> word.length() > 12);
            endParallel = System.currentTimeMillis() - startParallel;
        } else {
            start = System.currentTimeMillis();
            Files.lines(file.toPath()).map(line -> line.replaceAll("^\\W+|\\W+$", "").split("\\W+")).filter(line -> !"".equals(line[0])).flatMap(Arrays::stream).filter(word -> word.length() > 12);
            end = System.currentTimeMillis() - start;

            startParallel = System.currentTimeMillis();
            Files.lines(file.toPath()).parallel().map(line -> line.replaceAll("^\\W+|\\W+$", "").split("\\W+")).filter(line -> !"".equals(line[0])).flatMap(Arrays::stream).filter(word -> word.length() > 12);
            endParallel = System.currentTimeMillis() - startParallel;
        }

        System.out.println("General   : " + end + "ms\n" +
                "Parallel  : " + endParallel + "ms\n" +
                "Difference: " + (end - endParallel) + "ms");
    }
}
