package ru.mrchebik.task11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task11.color.ColorTransformer;

import java.util.function.UnaryOperator;

/**
 * Task:
 *      Implement static methods that can compose two 'ColorTransformer' objects, and a static method that turns a
 *  'UnaryOperator<Color>' into a 'ColorTransformer' that ignores the x- and y- coordinates. Then use these methods to
 *  add a gray frame to a brightened image. (See Exercise 5 for the gray frame.)
 *
 * Created by mrchebik on 8/16/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("photo.png");
        Image newImage = transform(image, compose(map(Color::brighter),
                (x, y, c) -> (
                        x <= 10 || x >= image.getWidth() - 10
                                || y <= 10 || y >= image.getHeight() - 10) ? Color.GREY : c));
        stage.setScene(new Scene(new HBox(new ImageView(newImage))));
        stage.show();
    }

    private static ColorTransformer compose(ColorTransformer transformer1, ColorTransformer transformer2) {
        return (x, y, c) -> transformer2.apply(x, y, transformer1.apply(x, y, c));
    }

    private static ColorTransformer map(UnaryOperator<Color> operator) {
        return (x, y, c) -> operator.apply(c);
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
