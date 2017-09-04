package ru.mrchebik.task10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task:
 *      Write a program that asks the user for a URL, then rads the web page at that URL, and then displays all the
 *  links. Use a 'CompletableFuture' for each stage. Don't call 'get'. To prevent your program from terminating
 *  prematurely, call
 *
            ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
 *
 *
 * Created by mrchebik on 9/4/17.
 */
public class Main {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> readPage("http://www.horstmann.com/"))
                .thenApply(Main::getLinks)
                .handle((l, e) -> {
                    if (e != null) {
                        System.out.println(e.getMessage());
                        return new ArrayList<>();
                    } else {
                        return l;
                    }
                })
                .thenAccept(l -> l.forEach(System.out::println));
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    private static String readPage(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            return content.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getLinks(String content) {
        List<String> links = new ArrayList<>();
        Pattern p = Pattern.compile("(?i)href=\"http://(.*?)\"");
        Matcher m = p.matcher(content);
        while (m.find()) {
            links.add(m.group(1));
        }
        return links;
    }
}
