package ru.mrchebik.task13.effect;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ru.mrchebik.task13.color.ColorTransformer;
import ru.mrchebik.task13.image.LatentImage;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentEffect {
    public static ColorTransformer blur() {
        return (x, y, c) -> {
            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;

            Image currImage = getImage();

            int width = (int) currImage.getWidth();
            int height = (int) currImage.getHeight();

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    Color color = currImage.getPixelReader().getColor((width + x + i) % width, (height + y + j) % height);

                    r += color.getRed();
                    g += color.getGreen();
                    b += color.getBlue();
                    counter++;
                }
            }

            return Color.color(r / counter, g / counter, b / counter);
        };
    }

    public static ColorTransformer edgeDetection() {
        return (x, y, c) -> {
            double r = c.getRed() * 4;
            double g = c.getGreen() * 4;
            double b = c.getBlue() * 4;

            Image currImage = getImage();

            int width = (int) currImage.getWidth();
            int height = (int) currImage.getHeight();

            Color[] neighbours = {
                    x > 0 ? currImage.getPixelReader().getColor((width + x - 1) % width, (height + y) % height) : Color.BLACK,
                    x < width ? currImage.getPixelReader().getColor((width + x + 1) % width, (height + y) % height) : Color.BLACK,
                    y > 0 ? currImage.getPixelReader().getColor((width + x) % width, (height + y - 1) % height) : Color.BLACK,
                    y < height ? currImage.getPixelReader().getColor((width + x) % width, (height + y + 1) % height) : Color.BLACK
            };

            for (Color color : neighbours) {
                r -= color.getRed();
                g -= color.getGreen();
                b -= color.getBlue();
            }

            return Color.color(roundColor(r), roundColor(g), roundColor(b));
        };
    }

    private static double roundColor(double value) {
        return value < 0 ? 0 : value > 1 ? 1 : value;
    }

    public static ColorTransformer frame() {
        return (x, y, c) -> {
            Image currImage = getImage();

            return (x <= 10 || x >= currImage.getWidth() - 10
                            || y <= 10 || y >= currImage.getHeight() - 10) ? Color.GRAY : c;
        };
    }

    private static Image getImage() throws Exception {
        Image temp = LatentImage.getImage();

        if (temp == null) {
            throw new Exception("'LatentEffect' depends from 'LatentImage'. You must put image to 'LatentImage'");
        }

        return temp;
    }
}
