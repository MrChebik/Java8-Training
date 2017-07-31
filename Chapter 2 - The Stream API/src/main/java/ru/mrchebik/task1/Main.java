package ru.mrchebik.task1;

import ru.mrchebik.task1.thread.MultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Task:
 *      Write a parallel version of the 'for' loop in Section 2.1, "From Iteration to Stream Operations", on page 22.
 *  Obtain the number of processors. Make that many separate threads, each working on a segment of the list, and total
 *  up the result as they come in. (You don't want the threads to update a single counter. Why?)
 *
 * Answer:
 *      Single counter return a negative number.
 *
 * Created by mrchebik on 7/30/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int sizeOfCores = 4;
        List<String> words = Arrays.asList(generateMassive(1000, 24));

        List<MultiThread> multiThreads = new ArrayList<>(sizeOfCores);

        int deliver = (words.size() / sizeOfCores);
        for (int i = 0; i < sizeOfCores; i++) {
            multiThreads.add(new MultiThread(words.subList(deliver * i, deliver * (i + 1)), 12));
        }

        multiThreads.forEach(Thread::start);

        for (MultiThread multiThread : multiThreads) {
            multiThread.join();
        }

        System.out.println(multiThreads.stream().mapToLong(MultiThread::getCountOfWords).sum());
    }

    private static String[] generateMassive(int lengthOfArray,
                                            int maxLengthOfWord) {
        String[] words = new String[lengthOfArray];
        Random random = new Random();
        for (int i = 0; i < lengthOfArray; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < random.nextInt(maxLengthOfWord - 1) + 1; j++) {
                word.append((char) (random.nextInt(25) + 97));
            }
            words[i] = word.toString();
        }
        return words;
    }
}
