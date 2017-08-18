package ru.mrchebik.task14.effect;

import javafx.scene.paint.Color;
import ru.mrchebik.task14.image.LatentImage;
import ru.mrchebik.task14.color.ColorTransformerPixelReader;

import java.util.Optional;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentEffect {
    public static ColorTransformerPixelReader blur() {
        return (x, y, reader) -> {
            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;

            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    Optional<Color> colorOptional = reader.get(x + i, y + j);
                    if (colorOptional.isPresent()) {
                        Color color = colorOptional.get();

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

    public static ColorTransformerPixelReader edgeDetection() {
        return (x, y, reader) -> {
            Color c = reader.get(x, y).get();
            Color n = reader.get(x, y - 1).orElse(Color.BLACK);
            Color e = reader.get(x + 1, y).orElse(Color.BLACK);
            Color s = reader.get(x, y + 1).orElse(Color.BLACK);
            Color w = reader.get(x - 1, y).orElse(Color.BLACK);
            return Color.color(
                    roundColor(4 * c.getRed() - n.getRed() - e.getRed() - s.getRed() - w.getRed()),
                    roundColor(4 * c.getGreen() - n.getGreen() - e.getGreen() - s.getGreen() - w.getGreen()),
                    roundColor(4 * c.getBlue() - n.getBlue() - e.getBlue() - s.getBlue() - w.getBlue())
            );
        };
    }

    private static double roundColor(double value) {
        return value < 0 ? 0 : value > 1 ? 1 : value;
    }

    public static ColorTransformerPixelReader frame() {
        return (x, y, reader) -> (x <= 10 || x >= LatentImage.width - 10
                        || y <= 10 || y >= LatentImage.height - 10) ? Color.GRAY : reader.get(x, y).get();
    }
}
