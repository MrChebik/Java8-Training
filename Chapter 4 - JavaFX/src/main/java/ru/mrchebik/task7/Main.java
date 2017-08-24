package ru.mrchebik.task7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Task:
 *      Find out how to set the border of a control without using CSS.
 *
 * Created by mrchebik on 8/24/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        Label label = new Label("Hello, FX!");
        label.setBorder(new Border(
                new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        null,
                        new BorderWidths(1))));
        pane.setCenter(label);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
