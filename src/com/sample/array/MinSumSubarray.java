package com.sample.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSumSubarray {

    public static void main(String[] args) {
        int[] input = { 2, 3, 1, 2, 4, 3 };
        minimumSubarray(input);
    }

    private static void minimumSubarray(int[] input) {
        int sum = 0;
        int target = 7;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            sum += input[cnt];

            while (sum >= target) {
                min = Math.min(min, cnt - i);
                sum -= input[i];
                i++;
            }
        }
        System.out.println("result => " + min);
    }
}
