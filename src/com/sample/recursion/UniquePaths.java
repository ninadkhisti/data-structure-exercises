package com.sample.recursion;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of UniquePaths
 */
public class UniquePaths {

    public static void main(String[] args) {
        printUniquePaths(7, 10);

    }

    private static void printUniquePaths(int i, int j) {
        int[][] matrix = new int[i][j];

        for (int cnt = 0; cnt < matrix.length; cnt++) {
            matrix[cnt][0] = 1;
        }
        for (int cnt = 0; cnt < matrix[0].length; cnt++) {
            matrix[0][cnt] = 1;
        }
        for (int cnt = 1; cnt < matrix.length; cnt++) {
            for (int icnt = 1; icnt < matrix[cnt].length; icnt++) {
                matrix[cnt][icnt] = matrix[cnt - 1][icnt] + matrix[cnt][icnt - 1];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(matrix[i - 1][j - 1]);
    }
}
