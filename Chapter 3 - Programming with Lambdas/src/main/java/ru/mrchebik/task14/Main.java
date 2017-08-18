package ru.mrchebik.task14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.mrchebik.task14.effect.LatentEffect;
import ru.mrchebik.task14.image.LatentImage;

/**
 * Task:
 *      To deal with lazy evaluation on a per-pixel basis, change the transformers so that they are passed a
 *  'PixelReader' object from which they can read other pixels in the image. For example,
 *  '(x, y, reader) -> reader.get(width - x, y)' is a mirroring operation. The convolution filters from the preceding
 *  exercises can be easily implemented in terms of such a reader. The straightforward operations would simply have the
 *  form '(x, y, reader) -> reader.get(x, y).grayscale()', and you can provide an adapter from 'UnaryOperation<Color>'.
 *  A 'PixelReader' is at a particular level in the pipeline of operations. Keep a cache recently read pixels at each
 *  level in the pipeline. If a reader is asked for a pixel, it looks in the cache (or in the original image at level
 *  0); if that fails, it constructs a reader that asks the previous transform.
 *
 * Created by mrchebik on 8/17/17.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("photo.png");
        Image finalImage = LatentImage.from(image)
                .transform(Color::brighter)
                .transform(LatentEffect::blur)
                .transform(LatentEffect::edgeDetection)
                .transform(LatentEffect::frame)
                .toImage();
        primaryStage.setScene(new Scene(new HBox(new ImageView(finalImage))));
        primaryStage.show();
    }
}
