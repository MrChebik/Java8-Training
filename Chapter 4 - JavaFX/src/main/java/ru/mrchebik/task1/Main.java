package ru.mrchebik.task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Task:
 *      Write a program with a text field and a label. As with the Hello, JavaFX program, the label should have the
 *  string Hello, FX in a 100 point font. Initialize the text field with the same string. Update the label as the user
 *  edits the text field.
 *
 * Created by mrchebik on 8/23/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label message = new Label("Hello, FX!");
        message.setFont(new Font(100));

        TextField textField = new TextField("Hello, FX!");

        message.textProperty().bind(textField.textProperty());

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(textField);
        borderPane.setTop(message);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }
}
