package com.sample.array;

import java.util.Arrays;

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
        //int[] input = { 2, 7, 3, 4, 9, 8, 12 };
        int length = LIS(input);
        int result = longestIncreasingSubseque(input);
        int bitonic = longestBitonicSubarray(input);
        int product = longestIncreasingSubseqWithProduct();
        System.out.println("bitonic length " + bitonic);
        System.out.println("length =>" + length);
        System.out.println("length1 =>" + result);
    }

    private static int longestIncreasingSubseqWithProduct() {
        int[] input = { 6, 7, 8, 11, 2, 3, 9, 10 };
        int[] lgr = new int[input.length];
        int lgre = 0;
        for (int cnt = input.length - 1; cnt >= 1; cnt--) {
            lgr[cnt] = lgre;
            if (input[cnt] > lgre) {
                lgre = input[cnt];
                lgr[cnt] = 0;
            }
        }
        System.out.println(Arrays.toString(lgr));
        return 0;
    }

    private static int longestBitonicSubarray(int[] input) {
        int[] increase = new int[input.length];
        int[] decrease = new int[input.length];

        increase[0] = 1;
        for (int cnt = 1; cnt < input.length; cnt++) {
            increase[cnt] = input[cnt] > input[cnt - 1] ? 1 + increase[cnt - 1] : 1;
        }
        decrease[input.length - 1] = 1;
        for (int cnt = input.length - 2; cnt >= 0; cnt--) {
            decrease[cnt] = input[cnt] > input[cnt + 1] ? 1 + decrease[cnt + 1] : 1;
        }

        int max = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            max = Math.max(max, increase[cnt] + decrease[cnt] - 1);
        }

        return max;
    }

    private static int longestIncreasingSubseque(int[] input) {
        int[] lis = new int[input.length];

        lis[0] = 1;
        for (int cnt = 1; cnt < input.length; cnt++) {
            int maxlis = 1;
            for (int icnt = 0; icnt < cnt; icnt++) {
                if (input[icnt] < input[cnt]) {
                    maxlis = Math.max(maxlis, lis[icnt] + 1);
                }
            }
            lis[cnt] = maxlis;
        }
        System.err.println(Arrays.toString(lis));
        return lis[lis.length - 1];
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
        System.out.println(Arrays.toString(subsequence));
        return maxLIS + 1;
    }
}
