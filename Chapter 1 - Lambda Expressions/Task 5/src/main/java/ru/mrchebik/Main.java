package ru.mrchebik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mrchebik on 7/24/17.
 */
public class Main {
    private static JButton button = new JButton();

    public static void main(String[] args) {
        setActionListener();
        setActionListenerLambda();

        setRunnable();
        setRunnableLambda();
    }

    private static void setActionListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });
    }

    // Save 5 lines of code
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

    // Save 5 lines of code
    private static void setRunnableLambda() {
        new Thread(() -> System.out.println("With Lambda"));
    }
}
