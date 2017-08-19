package ru.mrchebik.task15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task15.image.LatentImage;

/**
 * Task:
 *      Combine the lazy evaluation of Section 3.6, "Laziness", on page 56, with the parallel evaluation of Section 3.7,
 *  "Parallelizing Operations", on page 57.
 *
 * Created by mrchebik on 8/19/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("photo.png");
        Image finalImage = LatentImage.from(image)
                .transform(Color::brighter)
                .transform(Color::grayscale)
                .toImage();
        primaryStage.setScene(new Scene(new HBox(new ImageView(finalImage))));
        primaryStage.show();
    }
}
