package ru.mrchebik.task1;

import ru.mrchebik.Utils;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Task:
 *      Enhance the lazy logging technique by providing conditional logging. A typical call would be
 *  'logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10])'. Don't evaluate the condition if the logger won't log
 *  the message.
 *
 * Created by mrchebik on 8/12/17.
 */
public class Main extends Utils {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

        logger.setLevel(Level.FINEST);

        String[] a = generateMassive(20, 5);

        IntStream.range(0, a.length).forEach(i -> logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]));
    }

    private static void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
        if (logger.isLoggable(level) && condition.get()) {
            logger.log(level, message.get());
        }
    }
}
