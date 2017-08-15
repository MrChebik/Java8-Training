package ru.mrchebik.task8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task5.color.ColorTransformer;

/**
 * Task:
 *      Generalize Exercise 5 by writing a static method that yields a 'ColorTransformer' that adds a frame of arbitrary
 *  thickness and color to an image.
 *
 * Created by mrchebik on 8/15/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("photo.png");
        Image newImage = transform(image, setBorderAndColor(image, 20, 15, Color.AZURE));
        stage.setScene(new Scene(new HBox(new ImageView(newImage))));
        stage.show();
    }

    public static ColorTransformer setBorderAndColor(Image image, int x1, int y1, Color color) {
        return (x, y, c) -> (
                x <= x1 || x >= image.getWidth() - x1
                        || y <= y1 || y >= image.getHeight() - y1) ? color : c;
    }

    public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(x, y, in.getPixelReader().getColor(x, y)));
        return out;
    }
}
