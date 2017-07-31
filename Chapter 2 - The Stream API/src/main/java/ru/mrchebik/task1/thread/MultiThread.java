package ru.mrchebik.task1.thread;

import ru.mrchebik.task1.Main;

import java.util.List;

/**
 * Created by mrchebik on 7/31/17.
 */
public class MultiThread extends Thread {
    private long         countOfWords;
    private List<String> words;
    private final int    checkedLength;

    public MultiThread(List<String> words, int checkedLength) {
        this.countOfWords  = -1;
        this.words         = words;
        this.checkedLength = checkedLength;
    }

    public void run() {
        countOfWords = words.stream().parallel().filter(word -> word.length() > checkedLength - 1).count();
    }

    public long getCountOfWords() {
        return countOfWords;
    }
}
