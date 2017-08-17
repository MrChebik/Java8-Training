package ru.mrchebik.task13.operations;

import ru.mrchebik.task13.color.EnhancedColorTransformer;

/**
 * Created by mrchebik on 8/17/17.
 */
public class TransformOperations {
    public EnhancedColorTransformer transformer;
    public boolean eager;

    public TransformOperations(EnhancedColorTransformer transformer) {
        this.transformer = transformer;
    }

    public TransformOperations(EnhancedColorTransformer transformer, boolean eager) {
        this.transformer = transformer;
        this.eager = eager;
    }
}
