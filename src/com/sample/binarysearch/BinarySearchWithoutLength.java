package com.sample.binarysearch;

/**
 * Search sorted array without using length property.
 * 
 */
public class BinarySearchWithoutLength {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

        int query = 16;
        binarySearchWithoutLength(array, query);
    }

    private static void binarySearchWithoutLength(int[] array, int query) {
        int index = 1;
        while (array[index - 1] != -1 && array[index - 1] < query) {
            index *= 2;
        }
        int i = binarySearchModified(array, query, index / 2, index);
        System.out.println("Result " + i);
    }

    private static int binarySearchModified(int[] array, int query, int low, int high) {

        if (low > high)
            return -1;
        int mid = (low + high) / 2;

        if (array[mid] == query) {
            return array[mid];
        }
        if (array[mid] > query || array[mid] == -1) { //search left subtree
            return binarySearchModified(array, query, low, mid - 1);
        } else { //search right subtree
            return binarySearchModified(array, query, mid + 1, high);
        }
    }
}
