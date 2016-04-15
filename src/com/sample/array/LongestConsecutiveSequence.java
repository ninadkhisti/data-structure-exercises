package com.sample.array;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of LongestConsecutiveSequence
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] input = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(input));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> input = new HashSet<>();
        for (int num : nums) {
            input.add(num);
        }
        int maxLength = Integer.MIN_VALUE;
        while (!input.isEmpty()) {
            int entry = input.iterator().next();
            input.remove(entry);

            int lowerbound = entry - 1;
            while (input.contains(lowerbound)) {
                input.remove(lowerbound);
                lowerbound--;
            }
            int upperbound = entry + 1;
            while (input.contains(upperbound)) {
                input.remove(upperbound);
                upperbound++;
            }
            maxLength = Math.max(maxLength, upperbound - lowerbound - 1);
        }
        return maxLength;
    }
}
