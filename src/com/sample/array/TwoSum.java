package com.sample.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 2, 1, -4, -5, 4, -3 };
        int[] nums = { 3, 2, 4 };
        twosum(nums, 6);
        int sum = 5;
        Map<Integer, Integer> reminder = new HashMap<>();

        for (int cnt = 0; cnt < arr.length; cnt++) {
            int secondPart = sum - arr[cnt];
            if (reminder.containsKey(arr[cnt])) {
                int index1 = reminder.get(arr[cnt]);
                System.out.println("index1 " + index1 + " index2 " + cnt);
                break;
            }
            reminder.put(secondPart, cnt);
        }
    }

    private static int[] twosum(int[] nums, int target) {

        if (nums == null || nums.length <= 1)
            return null;

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[] { l, r };

    }

}
