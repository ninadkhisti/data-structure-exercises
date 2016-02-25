package com.sample.matrix;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of SparseMatrixMultiplication
 */
public class SparseMatrixMultiplication {

    public static void main(String[] args) {
        int[][] a = { { 1, 0, 0 }, { -1, 0, 3 } };
        int[][] b = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

        int[][] c = multiply(a, b);
        System.out.println(Arrays.deepToString(c));
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        // error checking
        if (a == null || b == null)
            return null;
        if (a[0].length != b.length)
            return null;

        int r = a.length;
        int c = b[0].length;
        int[][] product = new int[r][c];

        //product = a[0,0] * b [0,0] + a[0,1] * b[1,0] + a[0,2] * b[2,0]
        //product = a[1,0] * b [0,0] + a[1,1] * b[1,0] + a[1,2] * b[2,0]
        for (int i = 0; i < r; i++) {
            for (int k = 0; k < a[0].length; k++) {
                if (a[i][k] != 0) {
                    for (int j = 0; j < c; j++) {
                        product[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }

        return product;
    }
}
