package com.sample.array;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of RotateMatrix
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] input = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        rotate(input);
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(i + " => " + j);
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        System.out.println(Arrays.deepToString(matrix));
    }

}
