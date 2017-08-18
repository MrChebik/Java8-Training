package ru.mrchebik.task14.color;

import javafx.scene.paint.Color;

/**
 * Created by mrchebik on 8/18/17.
 */
@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}
