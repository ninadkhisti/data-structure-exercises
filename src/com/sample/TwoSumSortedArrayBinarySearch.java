package com.sample;

/**
 * TwoSum with sorted array
 */
public class TwoSumSortedArrayBinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 20 };
        int sum = 5;

        for (int ocnt = 0; ocnt < arr.length; ocnt++) {

        }
    }

    private static boolean find(int number, int[] arr) {
        int rootIndex = arr.length / 2;
        if (number == arr[rootIndex]) {
            return true;
        }

        if (number < arr[rootIndex]) {//search left subtree

        } else {//search right subtree

        }
        return true;
    }
}
