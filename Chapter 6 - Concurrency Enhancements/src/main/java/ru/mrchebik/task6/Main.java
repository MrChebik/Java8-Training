package ru.mrchebik.task6;

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
 *      Repeat the preceding exercise, but use 'computeIfAbsent' instead. What is the advantage of this approach?
 *
 * Answer:
 *      If word is absent, then 'computeIfAbsent' is execute.
 *
 * Created by mrchebik on 9/1/17.
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
        File[] files = {
                new File("/home/mrchebik/Documents/war-and-peace-part-1"),
                new File("/home/mrchebik/Documents/war-and-peace-part-2"),
        };
        Arrays.asList(files).parallelStream().forEach(f -> {
            try {
                Arrays.stream(new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8)
                        .split("[\\P{L}]+")).forEach(w ->
                        map.computeIfAbsent(w, k -> new HashSet<>()).add(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(map.get("war"));
    }
}
