package com.sample.array;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of MergeSortedArrays
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 5, 6, 7, 8, 9, 10, 20, 34, 50 };
        int[] arr2 = { 3, 5, 11 };

        System.out.println(mergeSortedArray(arr1, arr2).toString());
    }

    private static List<Integer> mergeSortedArray(int[] arr1, int[] arr2) {
        Integer[] result = new Integer[arr1.length + arr2.length];

        int rcnt = 0, i = 0, j = 0;
        while (true) {

            if (arr1[i] <= arr2[j]) {
                result[rcnt] = arr1[i];
                i++;
                if (i == arr1.length)
                    break;
            } else {
                result[rcnt] = arr2[j];
                j++;
                if (j == arr2.length)
                    break;
            }
            rcnt++;
        }
        rcnt++;
        while (i < arr1.length) {
            result[rcnt] = arr1[i];
            rcnt++;
            i++;
        }
        while (j < arr2.length) {
            result[rcnt] = arr2[j];
            rcnt++;
            j++;
        }

        return Arrays.asList(result);
    }
}
