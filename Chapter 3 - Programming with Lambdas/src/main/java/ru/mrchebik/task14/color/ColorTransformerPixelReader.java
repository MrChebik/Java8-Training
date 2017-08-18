package ru.mrchebik.task14.color;

import javafx.scene.paint.Color;
import ru.mrchebik.task14.transform.PixelReader;

/**
 * Created by mrchebik on 8/18/17.
 */
@FunctionalInterface
public interface ColorTransformerPixelReader {
    Color apply(int x, int y, PixelReader reader);
}
