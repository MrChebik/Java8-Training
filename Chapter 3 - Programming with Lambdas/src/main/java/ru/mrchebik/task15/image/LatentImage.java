package ru.mrchebik.task15.image;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ru.mrchebik.task15.pixel.Pixel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by mrchebik on 8/19/17.
 */
public class LatentImage {
    public static Image in;
    private static List<Pixel> pixels;
    private static List<UnaryOperator<Color>> pendingOperations;

    public static int width;
    public static int height;

    public static LatentImage from(Image image) {
        in = image;
        pixels = new ArrayList<>();
        pendingOperations = new ArrayList<>();

        width = (int) image.getWidth();
        height = (int) image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels.add(new Pixel(x, y, in.getPixelReader().getColor(x, y)));
            }
        }

        return new LatentImage();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);

        return this;
    }

    public Image toImage() throws Exception {
        pixels.parallelStream().forEach(p -> {
            Color c = p.getColor();
            for (UnaryOperator<Color> f : pendingOperations) c = f.apply(c);
            p.setColor(c);
        });
        WritableImage out = new WritableImage(width, height);
        pixels.forEach(p -> out.getPixelWriter().setColor(p.getX(), p.getY(), p.getColor()));

        return out;
    }
}
