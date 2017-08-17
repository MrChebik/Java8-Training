package ru.mrchebik.task13.color;

import javafx.scene.paint.Color;

/**
 * Created by mrchebik on 8/17/17.
 */
@FunctionalInterface
public interface EnhancedColorTransformer {
    Color apply(int x, int y, Color[][] colorAt);
}
