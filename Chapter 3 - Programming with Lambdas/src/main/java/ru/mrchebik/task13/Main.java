package ru.mrchebik.task13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task13.effect.LatentEffect;
import ru.mrchebik.task13.image.LatentImage;

/**
 * Task:
 *      Convolution filters such as blur or edge detection compute a pixel from neighboring pixels. To blur an image,
 *  replace each color value by the average of itself and its eight neighbors. For edge detection, replace each color
 *  value 'c' with '4c — n — e — s — w', where the other colors are those of the pixel to the north, east, south, and
 *  west. Note that these cannot be implemented lazily, using the approach of Section 3.6, "Laziness", on page 56, since
 *  they require the image from the previous stage (or at least the neighboring pixels) to have been computed. Enhance
 *  the lazy image processing to deal with these operations. Force computation of the previous stage when one of these
 *  operators is evaluated.
 *
 * Created by mrchebik on 8/16/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("photo.png");
        Image finalImage = LatentImage.from(image)
                .transform(Color::brighter)
                /*.transform(LatentEffect::blur)*/
                .transform(LatentEffect::edgeDetection)
                .transform(LatentEffect::edgeDetection)
                /*.transform(LatentEffect::frame)*/
                .toImage();
        primaryStage.setScene(new Scene(new HBox(new ImageView(finalImage))));
        primaryStage.show();
    }
}