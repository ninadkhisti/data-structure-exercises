package com.sample.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
[
 [ 1, 2, 3, 4 ],
 [ 12,13,14, 5 ],
 [ 11,16,15, 6 ],
 [ 10, 9, 8, 7 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralOrderMatrix {

    public static void main(String[] args) {
        //int[][] input = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        int[][] input = { { 2, 3 } };
        List<Integer> spiralOrder = spiralOrder(input);
        System.out.println(spiralOrder.toString());
        /*List<List<Integer>> diagonalOrder = diagonalOrder(input);
        rotateMatrix(input);
        matricesOfKsize(input);
        System.out.println(diagonalOrder.toString());
        int k = 10;
        constructSpiralOrder(k);*/
    }

    private static void rotateMatrix(int[][] input) {
        int rowbegin = 0;
        int rowend = input.length - 1;
        int colbegin = 0;
        int colend = input[0].length - 1;

        int prev = 0, current = 0;
        for (int icnt = 0; icnt < 1; icnt++) {
            prev = input[rowbegin + 1][colbegin];
            for (int cnt = colbegin; cnt <= colend; cnt++) {
                current = input[rowbegin][cnt];
                input[rowbegin][cnt] = prev;
                prev = current;
            }
            rowbegin++;
            for (int cnt = rowbegin; cnt <= rowend; cnt++) {
                current = input[cnt][colend];
                input[cnt][colend] = prev;
                prev = current;
            }
            colend--;
            for (int cnt = colend; cnt >= 0; cnt--) {
                current = input[rowend][cnt];
                input[rowend][cnt] = prev;
                prev = current;
            }
            rowend--;
            for (int cnt = rowend; cnt >= 0; cnt--) {
                current = input[cnt][colbegin];
                input[cnt][colbegin] = prev;
                prev = current;
            }
        }
        System.out.println("Rotate =>" + Arrays.deepToString(input));

    }

    private static void matricesOfKsize(int[][] input) {
        int k = 3;
        int r = input.length;
        int c = input[0].length;
        for (int i = 0; i < r - k + 1; i++) {
            for (int j = 0; j < c - k + 1; j++) {
                System.out.println("i =" + i + " j =" + j);
                for (int a = i; a < i + k; a++) {
                    for (int b = j; b < j + k; b++) {
                        System.out.println(input[a][b]);
                    }
                }
            }
        }
    }

    private static List<List<Integer>> diagonalOrder(int[][] input) {
        List<List<Integer>> result = new ArrayList<>();
        int rowbegin = 0;
        int rowend = input.length - 1;
        int colbegin = 0;
        int colend = input[0].length - 1;

        while (colbegin <= colend || rowbegin <= rowend) {
            List<Integer> diagonal = new ArrayList<>();
            for (int cnt = rowbegin; cnt < rowend; cnt++) { // this is to avoid printing diagonal number twice
                diagonal.add(input[cnt][colbegin]);
            }
            for (int cnt = colbegin; cnt <= colend; cnt++) {
                diagonal.add(input[rowend][cnt]);
            }
            rowend--;
            colbegin++;
            result.add(diagonal);
        }
        return result;
    }

    private static void constructSpiralOrder(int size) {
        int[][] matrix = new int[size][size];
        int start = 1;

        int rowbegin = 0;
        int colbegin = 0;
        int rowend = size;
        int colend = size;
        while (rowbegin <= rowend && colbegin <= colend) {
            for (int i = colbegin; i < colend; i++) {
                matrix[rowbegin][i] = start++;
            }
            rowbegin++;
            for (int j = rowbegin; j < rowend; j++) {
                matrix[j][colend - 1] = start++;
            }
            colend--;

            for (int k = colend - 1; k >= colbegin; k--) {
                matrix[rowend - 1][k] = start++;
            }

            rowend--;

            for (int l = rowend - 1; l >= rowbegin; l--) {
                matrix[l][colbegin] = start++;
            }

            colbegin++;
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    private static List<Integer> spiralOrder(int[][] input) {
        List<Integer> result = new ArrayList<>();
        int rowbegin = 0;
        int rowend = input.length - 1;
        int colbegin = 0;
        int colend = input[0].length - 1;

        while (rowbegin <= rowend && colbegin <= colend) {
            //move right
            for (int cnt = colbegin; cnt <= colend; cnt++) {
                result.add(input[rowbegin][cnt]);
            }
            rowbegin++;
            //move down
            for (int i = rowbegin; i <= rowend; i++) {
                result.add(input[i][colend - 1]);
            }
            colend--;
            //move left
            if (rowbegin <= rowend) {
                for (int j = colend; j >= colbegin; j--) {
                    result.add(input[rowend - 1][j]);
                }
            }
            rowend--;
            //move up
            if (colbegin <= colend) {
                for (int k = rowend; k >= rowbegin; k--) {
                    result.add(input[k][colbegin]);
                }
            }
            colbegin++;
        }
        return result;
    }
}
