package com.sample.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 */
public class MinRotatedArray {

    public static void main(String[] args) {
        Integer[] input = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMinimum(input));

        Integer[] input1 = { 4, 5, 6, 7, 0, 1, 2 };

    }

    private static int findMinimum(Integer[] input) {

        int low = 0;
        int high = input.length - 1;

        while (low < high && input[low] >= input[high]) {
            int mid = (low + high) / 2;
            if (input[mid] > input[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return input[low];
    }
}
