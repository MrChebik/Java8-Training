package ru.mrchebik.task11.color;

import javafx.scene.paint.Color;

/**
 * Created by mrchebik on 8/13/17.
 */
@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}
