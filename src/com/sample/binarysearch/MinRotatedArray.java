package com.sample.binarysearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 */
public class MinRotatedArray {

    public static void main(String[] args) {
        Integer[] input = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMinimum(input));

        Integer[] input1 = { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1 };
        System.out.println(findMinimumWithDups(input1));

    }

    private static int findMinimumWithDups(Integer[] input) {
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (input[mid] > input[low]) {
                low = mid + 1;
            } else if (input[mid] < input[low]) {
                high = mid;
            } else if (input[mid] == input[low]) {
                //high--;
                low++;
            }

        }
        return input[low];
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
