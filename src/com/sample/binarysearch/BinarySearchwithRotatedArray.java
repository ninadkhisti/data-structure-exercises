package com.sample.binarysearch;

/**
 * Modified Binary Search with rotated array
 */
public class BinarySearchwithRotatedArray {

    public static void main(String[] args) {
        int[] input = { 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] input1 = { 11, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 };
        int result = searchRotatedArray(input, 12, 0, input.length - 1);
        System.out.println(searchRotatedArrayWithDups(input1, 12));
        System.out.println("Result => " + result);
    }

    private static int searchRotatedArray(int[] input, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (input[mid] == target)
            return input[mid];

        if (input[low] <= input[mid]) { //left array is sorted
            if (target >= input[low] && target < input[mid]) {
                high = mid - 1; //search left
                return searchRotatedArray(input, target, low, high);
            } else {
                low = mid + 1; // search right
                return searchRotatedArray(input, target, low, high);
            }
        } else { //right array is sorted
            if (target > input[mid] && target <= input[high]) {
                low = mid + 1; // search right
                return searchRotatedArray(input, target, low, high);
            } else {
                high = mid - 1;//search left
                return searchRotatedArray(input, target, low, high);
            }
        }
    }

    private static int searchRotatedArrayWithDups(int[] input, int query) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (input[mid] == query)
                return input[mid];
            if (input[low] < input[mid]) { //left array is sorted
                if (query < input[mid] && query >= input[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (input[mid] < input[low]) { // right array is sorted
                if (query > input[mid] && query <= input[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                //high--;
                low++;
            }

        }
        return -1;
    }
}
