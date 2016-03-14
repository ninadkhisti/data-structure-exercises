package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of MaximalSquare
 */
public class MaximalSquare {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
        //int[][] matrix = { { 1 } };
        int square = maximalSquare(matrix);
        System.out.println(square);
    }

    private static int maximalSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int[][] result = new int[matrix.length + 1][matrix[0].length + 1];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    result[i][j] = Math.min(result[i - 1][j - 1], Math.min(result[i - 1][j], result[i][j - 1])) + 1;
                    maxArea = Math.max(maxArea, result[i][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return maxArea * maxArea;
    }
}
