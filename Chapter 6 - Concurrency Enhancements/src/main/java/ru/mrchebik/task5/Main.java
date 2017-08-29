package ru.mrchebik.task5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Task:
 *      Write an application in which multiple threads read all words from a collection of files. Use a
 *  'ConcurrentHashMap<String, Set<File>>' to track in which files each word occurs. Use the `merge` method to update
 *  the map.
 *
 * Created by mrchebik on 8/28/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
        File[] files = {
                new File("/home/mrchebik/Documents/war-and-peace-part-1"),
                new File("/home/mrchebik/Documents/war-and-peace-part-2"),
        };
        Arrays.asList(files).parallelStream().forEach(f -> {
            try {
                Arrays.stream(new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8)
                        .split("[\\P{L}]+")).forEach(w ->
                        map.merge(w, new HashSet<>(), (existingValue, newValue) -> existingValue).add(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(map.get("war"));
    }
}
