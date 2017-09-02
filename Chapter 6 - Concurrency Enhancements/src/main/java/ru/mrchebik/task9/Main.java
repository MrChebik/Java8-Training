package ru.mrchebik.task9;

import ru.mrchebik.task9.matrix.Matrix;

import java.util.Arrays;

/**
 * Task:
 *      You can use the 'parallelPrefix' method to parallelize the computation of Fibonacci numbers. We use the fact
 *  that the 'n'th Fibonacci number is the top left coefficient of F^'n', where F = ( 1 1 1 0 ). Make an array filled
 *  with 2 × 2 matrices. Define a 'Matrix' class with a multiplication method, use 'parallelSetAll' to make an array of
 *  matrices, and use 'parallelPrefix' to multiply them.
 *
 * Created by mrchebik on 9/1/17.
 */
public class Main {
    public static void main(String[] args) {
        Matrix[] array = new Matrix[10];
        final int[][] f = {{1, 1}, {1, 0}};
        Arrays.parallelSetAll(array, i -> new Matrix(f));
        Arrays.parallelPrefix(array, Matrix::multiply);

        System.out.println(array[0].m[0][0]);
        System.out.println(array[9].m[0][0]);
    }
}
