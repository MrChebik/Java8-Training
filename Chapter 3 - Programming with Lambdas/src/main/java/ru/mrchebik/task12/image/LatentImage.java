package ru.mrchebik.task12.image;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ru.mrchebik.task12.color.ColorTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage latentImage = new LatentImage();
        latentImage.in = in;
        latentImage.pendingOperations = new ArrayList<>();

        return latentImage;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(map(f));

        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);

        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }

        return out;
    }

    private ColorTransformer map(UnaryOperator<Color> operator) {
        return (x, y, c) -> operator.apply(c);
    }
}
