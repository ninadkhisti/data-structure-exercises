package com.sample;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of SelectionAlgorithm
 */
public class SelectionAlgorithm {

    public static void main(String[] args) {
        int[] input = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(input, k));
    }

    public static int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo]))
                ;
            while (j > lo && less(a[lo], a[--j]))
                ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        System.out.println(Arrays.toString(a));
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }
}
