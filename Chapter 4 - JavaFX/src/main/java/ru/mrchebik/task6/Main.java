package ru.mrchebik.task6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Task:
 *      Center the top and bottom buttons in Figure 4-7.
 *
 * Created by mrchebik on 8/24/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        Button top = new Button("Top");
        BorderPane.setAlignment(top, Pos.CENTER);
        pane.setTop(top);
        pane.setLeft(new Button("Left"));
        pane.setCenter(new Button("Center"));
        pane.setRight(new Button("Right"));
        Button bottom = new Button("Bottom");
        pane.setBottom(bottom);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
