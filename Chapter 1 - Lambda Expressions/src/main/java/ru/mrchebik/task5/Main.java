package ru.mrchebik.task5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Task:
 *      Take a file from one of your projects that contains a number of 'ActionListener', 'Runnable', or other like.
 *  Replace them with lambda expression. How many lines did it save? Was the code easier to read? Where you able to use
 *  method references?
 *
 * Answer:
 *      Save 5 lines of code.
 *
 * Created by mrchebik on 7/24/17.
 */
public class Main {
    private static JButton button = new JButton();

    private static void setActionListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });
    }

    private static void setActionListenerLambda() {
        button.addActionListener(System.out::println);
    }

    private static void setRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Without Lambda");
            }
        });
    }

    private static void setRunnableLambda() {
        new Thread(() -> System.out.println("With Lambda"));
    }
}
