package com.sample.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such 
 * that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class DuplicateIndexes {

    public static void main(String[] args) {
        int[] input = { 1, 5, 6, 2, 1, 3, 4, 5, 2, 3, 1, 0, 1, 6, 7, 8, 3, 0, 1 };
        findDuplicateIndexes(input);
        boolean result = duplicateIndexes(input, 3);
        boolean result1 = duplicateIndexesII(input, 3);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(Integer.MIN_VALUE);
    }

    private static boolean duplicateIndexesII(int[] input, int k) {
        if (input == null || input.length <= 1 || k <= 0)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (cnt > k)
                set.remove(input[cnt - k - 1]);
            System.out.println(set.toString());
            if (!set.add(input[cnt])) {
                return true;
            }
        }

        return false;
    }

    private static boolean duplicateIndexes(int[] nums, int k) {
        if (nums.length == 0 || k <= 0)
            return false;
        for (int cnt = 0; cnt < nums.length - k; cnt++) {
            for (int j = cnt + 1; j < cnt + k; j++) {
                if (nums[cnt] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
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
