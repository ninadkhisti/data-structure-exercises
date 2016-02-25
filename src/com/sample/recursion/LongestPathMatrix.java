package com.sample.recursion;

/**
 * TODO: Describe purpose and behavior of LongestPathMatrix
 */
public class LongestPathMatrix {

    public static void main(String[] args) {
        int[][] input = { { 9, 10, 15 }, { 6, 6, 8 }, { 2, 1, 1 } };

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                max = Math.max(max, longestPath(i, j, input, 0, 0));
            }
        }
        System.out.println(max);
    }

    private static int longestPath(int i, int j, int[][] input, int previous, int k) {
        if (i < 0 || i >= input.length || j < 0 || j >= input[0].length) {
            return k;
        }

        if (input[i][j] > previous) {
            int temp = input[i][j];
            input[i][j] = -1;

            int a = longestPath(i + 1, j, input, temp, k + 1);
            int b = longestPath(i - 1, j, input, temp, k + 1);
            int c = longestPath(i, j + 1, input, temp, k + 1);
            int d = longestPath(i, j - 1, input, temp, k + 1);
            k = Math.max(Math.max(Math.max(a, b), c), d);

            input[i][j] = temp;
            return k;
        }
        return k;
    }
}
