package ru.mrchebik.task9;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Task:
 *      Animate a circle, representing a planet, so it travels along an elliptical orbit. Use a 'PathTransition'.
 *
 * Created by mrchebik on 8/24/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 205, 215, Color.GHOSTWHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        Circle circle = new Circle(20, 20, 15);
        circle.setFill(Color.BLUE);

        Path path = new Path();

        ArcTo arcTo = new ArcTo();
        arcTo.setX(151);
        arcTo.setY(30);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(50);
        arcTo.setRadiusY(100);
        arcTo.setXAxisRotation(45);

        path.getElements().add(new MoveTo(150, 30));
        path.getElements().add(arcTo);
        path.getElements().add(new ClosePath());

        path.setStroke(Color.DODGERBLUE);
        path.getStrokeDashArray().setAll(5d, 5d);
        path.setOpacity(0.5);

        group.getChildren().add(path);
        group.getChildren().add(circle);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(10));
        pathTransition.setPath(path);
        pathTransition.setNode(circle);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
    }
}
