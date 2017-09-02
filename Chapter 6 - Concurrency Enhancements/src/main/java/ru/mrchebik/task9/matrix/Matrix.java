package ru.mrchebik.task9.matrix;

/**
 * Created by mrchebik on 9/1/17.
 */
public class Matrix {
    public int[][] m;

    public Matrix(int[][] m) {
        this.m = m;
    }

    public Matrix multiply(Matrix other) {
        int x1 = m[0][0] * other.m[0][0] + m[0][1] * other.m[1][0];
        int y1 = m[0][0] * other.m[0][1] + m[0][1] * other.m[1][1];
        int x2 = m[1][0] * other.m[0][0] + m[1][1] * other.m[1][0];
        int y2 = m[1][0] * other.m[0][1] + m[1][1] * other.m[1][1];

        return new Matrix(new int[][]{{x1, y1}, {x2, y2}});
    }
}
