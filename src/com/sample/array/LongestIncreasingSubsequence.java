package com.sample.array;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3, 4, 5],
 * The longest increasing subsequence is [2, 3, 7, s101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] input = { 10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3, 4, 5 };
        int length = LIS(input);
        System.out.println("length =>" + length);
    }

    private static int LIS(int[] input) {

        int[] subsequence = new int[input.length];

        subsequence[0] = 0;
        int previousHigh = 0;
        int maxLIS = 0;
        for (int cnt = 1; cnt < input.length; cnt++) {
            if (input[cnt] > input[cnt - 1]) {
                if (previousHigh < input[cnt]) {
                    subsequence[cnt] = subsequence[cnt - 1] + 1;
                } else { //begining new of subsequence
                    subsequence[cnt] = 1;
                }

                previousHigh = input[cnt];
            } else {
                subsequence[cnt] = subsequence[cnt - 1];
            }
            if (maxLIS < subsequence[cnt]) {
                maxLIS = subsequence[cnt];
            }
        }
        return maxLIS + 1;
    }
}
