package ru.mrchebik.task13.effect;

import javafx.scene.paint.Color;
import ru.mrchebik.task13.color.ColorTransformer;
import ru.mrchebik.task13.color.EnhancedColorTransformer;
import ru.mrchebik.task13.image.LatentImage;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentEffect {
    public static EnhancedColorTransformer blur() {
        return (x, y, c) -> {
            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (x + i >= 0 && y + j >= 0 && x + i < LatentImage.width && y + j < LatentImage.height) {
                        Color color = c[x + i][y + j];

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

    public static EnhancedColorTransformer edgeDetection() {
        return (x, y, c) -> {
            Color n = y > 0 ? c[x][y - 1] : Color.BLACK;
            Color e = x < LatentImage.width - 1 ? c[x + 1][y] : Color.BLACK;
            Color s = y < LatentImage.height - 1 ? c[x][y + 1] : Color.BLACK;
            Color w = x > 0 ? c[x - 1][y] : Color.BLACK;
            return Color.color(
                    roundColor(4 * c[x][y].getRed() - n.getRed() - e.getRed() - s.getRed() - w.getRed()),
                    roundColor(4 * c[x][y].getGreen() - n.getGreen() - e.getGreen() - s.getGreen() - w.getGreen()),
                    roundColor(4 * c[x][y].getBlue() - n.getBlue() - e.getBlue() - s.getBlue() - w.getBlue())
            );
        };
    }

    private static double roundColor(double value) {
        return value < 0 ? 0 : value > 1 ? 1 : value;
    }

    public static EnhancedColorTransformer frame() {
        return (x, y, c) -> (x <= 10 || x >= LatentImage.width - 10
                        || y <= 10 || y >= LatentImage.height - 10) ? Color.GRAY : c[x][y];
    }
}
