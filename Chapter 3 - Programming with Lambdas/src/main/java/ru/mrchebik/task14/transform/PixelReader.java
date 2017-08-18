package ru.mrchebik.task14.transform;

import javafx.scene.paint.Color;
import ru.mrchebik.task14.image.LatentImage;

import java.util.Optional;

/**
 * Created by mrchebik on 8/18/17.
 */
public class PixelReader {
    private int level;

    public PixelReader(int level) {
        this.level = level;
    }

    public Optional<Color> get(int x, int y) {
        if (x < 0 || x >= LatentImage.width || y < 0 || y >= LatentImage.height) {
            return Optional.empty();
        }

        if (level == 0) {
            return Optional.of(LatentImage.pixelReader.getColor(x, y));
        }

        Color[][] levelCache = LatentImage.cache.get(level - 1);

        if (levelCache[x][y] != null) {
            return Optional.of(levelCache[x][y]);
        }

        levelCache[x][y] = LatentImage.pendingOperations.get(level - 1).apply(x, y, new PixelReader(level - 1));

        return Optional.of(levelCache[x][y]);
    }
}
