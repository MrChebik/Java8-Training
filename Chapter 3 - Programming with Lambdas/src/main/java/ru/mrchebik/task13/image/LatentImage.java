package ru.mrchebik.task13.image;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ru.mrchebik.task13.color.EnhancedColorTransformer;
import ru.mrchebik.task13.operations.TransformOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by mrchebik on 8/16/17.
 */
public class LatentImage {
    public static Image in;
    private static List<Color[][]> stages;
    private static List<TransformOperations> pendingOperations;

    public static int width;
    public static int height;

    public static PixelReader pixelReader;

    public static LatentImage from(Image image) {
        in = image;
        stages = new ArrayList<>();
        pendingOperations = new ArrayList<>();

        width = (int) image.getWidth();
        height = (int) image.getHeight();

        pixelReader = image.getPixelReader();

        Color[][] initStage = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                initStage[x][y] = pixelReader.getColor(x, y);
            }
        }

        stages.add(initStage);

        return new LatentImage();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(new TransformOperations(map(f)));
        stages.add(new Color[width][height]);

        return this;
    }

    public LatentImage transform(Supplier<EnhancedColorTransformer> f) {
        pendingOperations.add(new TransformOperations(f.get(), true));
        stages.add(new Color[width][height]);

        return this;
    }

    public Image toImage() throws Exception {
        WritableImage out = new WritableImage(width, height);

        for (int i = pendingOperations.size() - 1; i > 0; i--) {
            if (pendingOperations.get(i).eager) {
                List<TransformOperations> subOperations = pendingOperations.subList(0, i);

                for (int k = 0; k < subOperations.size(); k++) {
                    Color[][] stage = new Color[width][height];
                    for (int x = 0; x < width; x++) {
                        for (int y = 0; y < height; y++) {
                            stage[x][y] = subOperations.get(k).transformer.apply(x, y, stages.get(k));
                        }
                    }
                    stages.set(k + 1, stage);
                }

                break;
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = pixelReader.getColor(x, y);

                for (int i = 0; i < pendingOperations.size(); i++) {
                    Color[][] nextStage = stages.get(i + 1);
                    if(nextStage[x][y] == null) {
                        c = pendingOperations.get(i).transformer.apply(x, y, stages.get(i));
                        nextStage[x][y] = c;
                    }
                }

                out.getPixelWriter().setColor(x, y, c);
            }
        }

        return out;
    }

    private EnhancedColorTransformer map(UnaryOperator<Color> operator) {
        return (x, y, c) -> operator.apply(c[x][y]);
    }
}
