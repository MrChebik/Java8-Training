package ru.mrchebik.task12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task12.image.LatentImage;

/**
 * Task:
 *      Enhance the 'LatentImage' class in Section 3.6, "Laziness", on page 56, so that it supports both
 *  'UnaryOperator<Color>' and 'ColorTransformer'. Hint: Adapt the former to the latter.
 *
 * Created by mrchebik on 8/16/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("photo.png");
        Image finalImage = LatentImage.from(image)
                .transform(Color::brighter)
                .transform(Color::grayscale)
                .transform((x, y, c) -> (
                        x <= 10 || x >= image.getWidth() - 10
                                || y <= 10 || y >= image.getHeight() - 10) ? Color.GRAY : c)
                .toImage();
        primaryStage.setScene(new Scene(new HBox(new ImageView(finalImage))));
        primaryStage.show();
    }
}
