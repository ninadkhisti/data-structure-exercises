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

    private static int numberOfPaths(int[][] a, int M, int N) {
        if (a == null || a.length == 0 || a[0].length == 0 || M == 0 || N == 0)
            return 0;
        int rows = M;
        int columns = N;
        int[][] paths = new int[rows][columns];

        paths[0][0] = a[0][0];
        for (int cnt = 1; cnt < rows; cnt++) {
            paths[cnt][0] = a[cnt][0] * paths[cnt - 1][0];
        }
        for (int cnt = 1; cnt < columns; cnt++) {
            paths[0][cnt] = a[0][cnt] * paths[0][cnt - 1];
        }
        for (int cnt = 1; cnt < rows; cnt++) {
            for (int icnt = 1; icnt < columns; icnt++) {
                if (a[cnt][icnt] == 1) {
                    paths[cnt][icnt] = paths[cnt - 1][icnt] + paths[cnt][icnt - 1];
                }
                if (a[cnt][icnt] == 0) {
                    paths[cnt][icnt] = 0;
                }
            }
        }
        return paths[rows - 1][columns - 1] % 1000000007;
    }
}
