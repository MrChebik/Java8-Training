package ru.mrchebik.task13.effect;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ru.mrchebik.task13.color.ColorTransformer;
import ru.mrchebik.task13.image.LatentImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentEffect {
    private static Image in;

    private static int width;
    private static int height;

    public static ColorTransformer blur() {
        List<ColorTransformer> precedingOperations = new ArrayList<>(LatentImage.getPendingOperations());

        return (x, y, c) -> {
            getImage();

            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (x + i >= 0 && y + j >= 0 && x + i < width && y + j < height) {
                        Color color = applyOperations(precedingOperations, x + i, y + j);

                        r += color.getRed();
                        g += color.getGreen();
                        b += color.getBlue();
                        counter++;
                    }
                }
            }

            return Color.color(r / counter, g / counter, b / counter);
        };
    }

    public static ColorTransformer edgeDetection() {
        List<ColorTransformer> precedingOperations = new ArrayList<>(LatentImage.getPendingOperations());

        return (x, y, c) -> {
            getImage();

            double r = c.getRed() * 4;
            double g = c.getGreen() * 4;
            double b = c.getBlue() * 4;

            Color[] neighbours = {
                    x > 0 ? applyOperations(precedingOperations, x - 1, y) : Color.BLACK,
                    x < width ? applyOperations(precedingOperations, x + 1, y) : Color.BLACK,
                    y > 0 ? applyOperations(precedingOperations, x, y - 1) : Color.BLACK,
                    y < height ? applyOperations(precedingOperations, x, y + 1) : Color.BLACK
            };

            for (Color color : neighbours) {
                r -= color.getRed();
                g -= color.getGreen();
                b -= color.getBlue();
            }

            return Color.color(roundColor(r), roundColor(g), roundColor(b));
        };
    }

    private static Color applyOperations(List<ColorTransformer> precedingOperations, int x, int y) throws Exception {
        Color color = in.getPixelReader().getColor((width + x) % width, (height + y) % height);

        for (ColorTransformer operation : precedingOperations) {
            color = operation.apply(x, y, color);
        }

        return color;
    }

    private static double roundColor(double value) {
        return value < 0 ? 0 : value > 1 ? 1 : value;
    }

    public static ColorTransformer frame() {
        return (x, y, c) -> {
            getImage();

            return (x <= 10 || x >= width - 10
                            || y <= 10 || y >= height - 10) ? Color.GRAY : c;
        };
    }

    private static void getImage() throws Exception {
        if (in == null) {

            in = LatentImage.getImage();

            if (in == null) {
                throw new Exception("'LatentEffect' depends from 'LatentImage'. You must put image to 'LatentImage'");
            }

            width = (int) in.getWidth();
            height = (int) in.getHeight();
        }
    }
}
