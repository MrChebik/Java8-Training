package ru.mrchebik.task13.image;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ru.mrchebik.task13.color.ColorTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentImage {
    private static Image in;
    private static List<ColorTransformer> pendingOperations;

    public static LatentImage from(Image image) {
        in = image;
        pendingOperations = new ArrayList<>();

        return new LatentImage();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(map(f));

        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);

        return this;
    }

    public LatentImage transform(Supplier<ColorTransformer> f) {
        pendingOperations.add(f.get());

        return this;
    }

    public Image toImage() throws Exception {
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

    public static Image getImage() {
        return in;
    }
}
