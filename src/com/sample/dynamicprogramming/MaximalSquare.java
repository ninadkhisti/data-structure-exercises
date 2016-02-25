package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of MaximalSquare
 */
public class MaximalSquare {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
        int square = maximalSquare(matrix);
        System.out.println(square);
    }

    private static int maximalSquare(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int maxlen = Integer.MIN_VALUE;
        int[][] result = new int[r][c];
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j])) + 1;
                    maxlen = Math.max(maxlen, result[i][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return maxlen * maxlen;
    }
}
