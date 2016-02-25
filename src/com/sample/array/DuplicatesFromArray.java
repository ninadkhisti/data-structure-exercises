package com.sample.array;

/**
 * TODO: Describe purpose and behavior of DuplicatesFromArray
 */
public class DuplicatesFromArray {

    public static void main(String[] args) {
        int[] input = { 1, 2, 5, 3, 4, 5, 6, 7, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 9, 10 };
        System.out.println(findDuplicate(input));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
