package com.sample.array;

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
        int[][] input = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        List<Integer> spiralOrder = spiralOrder(input);
        System.out.println(spiralOrder.toString());
        int k = 10;
        constructSpiralOrder(k);
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
        int rowend = input.length;
        int colbegin = 0;
        int colend = input[0].length;

        while (rowbegin <= rowend && colbegin <= colend) {
            //move right
            for (int cnt = colbegin; cnt < colend; cnt++) {
                result.add(input[rowbegin][cnt]);
            }
            rowbegin++;
            //move down
            for (int i = rowbegin; i < rowend; i++) {
                result.add(input[i][colend - 1]);
            }
            colend--;
            //move left
            for (int j = colend - 1; j >= colbegin; j--) {
                result.add(input[rowend - 1][j]);
            }
            rowend--;
            //move up
            for (int k = rowend - 1; k >= rowbegin; k--) {
                result.add(input[k][colbegin]);
            }
            colbegin++;
        }
        return result;
    }
}
