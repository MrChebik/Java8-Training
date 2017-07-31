package ru.mrchebik.task1;

import ru.mrchebik.task1.exception.ThrowingConsumer;
import ru.mrchebik.task1.thread.MultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

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
    private static final int NUMBER_OF_CORES    = Runtime.getRuntime().availableProcessors();
    private static final int CHECKED_LENGTH     = 12;

    private static final int MAX_LENGTH_OF_WORD = 24;
    private static final int LENGTH_OF_ARRAY    = 1000;

    public static void main(String[] args) {
        List<MultiThread> multiThreads = new ArrayList<>(NUMBER_OF_CORES);
        List<String>      words        = Arrays.asList(generateMassive(LENGTH_OF_ARRAY, MAX_LENGTH_OF_WORD));

        int deliver = (words.size() / NUMBER_OF_CORES);
        for (int i = 0; i < NUMBER_OF_CORES; i++) {
            multiThreads.add(new MultiThread(words.subList(deliver * i, deliver * (i + 1)), CHECKED_LENGTH));
        }

        multiThreads.forEach(Thread::start);
        multiThreads.forEach(handlingConsumerWrapper(Thread::join, InterruptedException.class));

        System.out.println(multiThreads.stream().mapToLong(MultiThread::getCountOfWords).sum());
    }

    private static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
            ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    System.err.println("Exception occurred : " + exceptionClass.cast(ex).getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
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
