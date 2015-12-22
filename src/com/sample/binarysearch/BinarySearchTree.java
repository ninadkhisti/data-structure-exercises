package com.sample.binarysearch;

/**
 * binary search
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        int[] input = { 1, 2, 5, 6, 7, 8, 9, 10, 20, 34, 35, 36, 40, 41, 42, 43, 44, 48, 49, 50 };
        int query = 45;

        System.out.println(binarySearch(input, query, 0, input.length - 1));
        System.out.println(binarySearchII(input, query));
    }

    private static int binarySearchII(int[] input, int query) {
        int low = 0;
        int high = input.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (input[mid] == query) {
                return input[mid];
            }
            if (query > input[mid]) { //right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] input, int query, int low, int high) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (query == input[mid])
            return input[mid];
        if (query < input[mid]) {
            return binarySearch(input, query, low, mid - 1);
        } else {
            return binarySearch(input, query, mid + 1, high);
        }

    }
}
