package ru.mrchebik.task14.image;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ru.mrchebik.task14.color.ColorTransformerPixelReader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Created by mrchebik on 8/18/17.
 */
public class LatentImage {
    public static Image in;
    public static List<Color[][]> cache;
    public static List<ColorTransformerPixelReader> pendingOperations;

    public static int width;
    public static int height;

    public static PixelReader pixelReader;

    public static LatentImage from(Image image) {
        in = image;
        cache = new ArrayList<>();
        pendingOperations = new ArrayList<>();

        width = (int) image.getWidth();
        height = (int) image.getHeight();

        pixelReader = image.getPixelReader();

        return new LatentImage();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(map(f));

        return this;
    }

    public LatentImage transform(Supplier<ColorTransformerPixelReader> f) {
        pendingOperations.add(f.get());

        return this;
    }

    public Image toImage() throws Exception {
        for (int i = 0; i < pendingOperations.size() - 1; i++) {
            cache.add(new Color[width][height]);
        }

        WritableImage out = new WritableImage(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = pixelReader.getColor(x, y);

                for (int i = 0; i < pendingOperations.size(); i++) {
                    ColorTransformerPixelReader operation = pendingOperations.get(i);

                    c = operation.apply(x, y, new ru.mrchebik.task14.transform.PixelReader(i));

                    if (i < pendingOperations.size() - 1 && cache.get(i)[x][y] == null) {
                        cache.get(i)[x][y] = c;
                    }
                }

                out.getPixelWriter().setColor(x, y, c);
            }
        }

        return out;
    }

    private ColorTransformerPixelReader map(UnaryOperator<Color> operator) {
        return (x, y, reader) -> operator.apply(reader.get(x, y).get());
    }
}
