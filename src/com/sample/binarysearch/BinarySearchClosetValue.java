package com.sample.binarysearch;

/**
 * TODO: Describe purpose and behavior of BinarySearchClosetValue
 */
public class BinarySearchClosetValue {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 17, 18, 19, 20, 21, 22 };

        int value = binarySearch(array, 14);
        System.out.println(value);
    }

    private static int binarySearch(int[] array, int i) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;

            if (i == array[mid]) {
                return array[mid];
            }
            if (array[mid] > i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return array[mid];
    }

}
