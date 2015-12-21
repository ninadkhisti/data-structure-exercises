package com.sample.array;

/**
 * TwoSum with sorted array
 */
public class TwoSumSortedArrayBinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 20 };
        int sum = 10;

        for (int ocnt = 0; ocnt < arr.length; ocnt++) {
            if (arr[ocnt] >= sum)
                break;
            int reminder = sum - arr[ocnt];
            int result = binarySearch(arr, reminder, ocnt + 1, arr.length);
            if (result != -1) {
                System.out.println("Pair => " + result + "," + arr[ocnt]);
            }

        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return arr[mid];
        }
        if (arr[mid] < key) { //right tree
            return binarySearch(arr, key, mid + 1, high);
        } else { //left tree
            return binarySearch(arr, key, low, mid - 1);
        }
    }

}
