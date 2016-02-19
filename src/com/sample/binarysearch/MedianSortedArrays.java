package com.sample.binarysearch;

/**
 * TODO: Describe purpose and behavior of MedianSortedArrays
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] ar1 = { 1, 12, 15, 26, 38 };
        int[] ar2 = { 2, 13, 17, 30, 45 };

        int median = median(ar1, ar2);
        System.out.println(median);
    }

    private static int median(int[] ar1, int[] ar2) {
        int l = 0;
        int r = ar1.length - 1;

        int mid = (l + r) / 2;
        while (l < r) {
            if (ar1[mid] > ar2[mid] && mid < r && ar1[mid] <= ar2[mid + 1]) {
                return (ar1[mid] + ar2[mid]) / 2;
            }
        }

        return 0;
    }
}
