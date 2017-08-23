package ru.mrchebik.task4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.divide;
import static javafx.beans.binding.Bindings.min;

/**
 * Task:
 *      Enhance the program in Section 4.5, "Bindings", on page 75 so that the circle stays centered and always touches
 *  at least two of the sides of the scene.
 *
 * Created by mrchebik on 8/23/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circle = new Circle(100, 100, 100);
        circle.setFill(Color.RED);
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane);
        circle.centerXProperty().bind(divide(scene.widthProperty(), 2));
        circle.centerYProperty().bind(divide(scene.heightProperty(), 2));
        circle.radiusProperty().bind(
                min(
                        divide(scene.widthProperty(), 2),
                        divide(scene.heightProperty(), 2))
        );
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
