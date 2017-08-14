package ru.mrchebik.task6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.BiFunction;

/**
 * Task:
 *      Complete the method
 *
 *          public static <T> Image transform(Image in, BiFunction<Color, T> f, T arg)
 *
 *  from Section 3.4, "Returning Functions", on page 53.
 *
 * Created by mrchebik on 8/14/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("photo.png");
        Image newImage = transform(image,
                (c, factor) -> c.deriveColor(0, 1, factor, 1),
                1.2);
        stage.setScene(new Scene(new HBox(new ImageView(newImage))));
        stage.show();
    }

    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y), arg));

        return out;
    }
}
