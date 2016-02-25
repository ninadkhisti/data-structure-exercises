package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] input = { 10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3, 4, 5 };
        int lis = longestincreasingsubsequence(input);
        System.out.println(lis);
    }

    private static int longestincreasingsubsequence(int[] input) {
        int[] lis = new int[input.length];
        int max = Integer.MIN_VALUE;

        lis[0] = 1;
        for (int cnt = 1; cnt < input.length; cnt++) {
            lis[cnt] = 1;
            if (input[cnt] > input[cnt - 1]) {
                lis[cnt] = lis[cnt - 1] + 1;
                max = Math.max(max, lis[cnt]);
            } else {
                int temp = cnt - 2;
                wloop: while (temp > 0) {
                    if (input[temp] < input[cnt]) {
                        lis[cnt] = lis[temp] + 1;
                        max = Math.max(max, lis[cnt]);
                        break wloop;
                    }
                    temp--;
                }
            }
        }
        System.out.println(Arrays.toString(lis));
        return max;
    }
}
