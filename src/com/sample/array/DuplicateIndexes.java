package com.sample.array;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such 
 * that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class DuplicateIndexes {

    public static void main(String[] args) {
        int[] input = { 1, 2, 1, 3, 2, 3, 1, 0, 3, 0, 1 };
        findDuplicateIndexes(input);
    }

    private static void findDuplicateIndexes(int[] input) {
        int k = 3;
        int previousIndex = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (input[cnt] == k) {
                if (previousIndex > 0 && Math.abs(previousIndex - cnt) <= k) {
                    System.out.println("indexes => " + cnt + " " + previousIndex);
                }
                previousIndex = cnt;
            }
        }
    }
}
