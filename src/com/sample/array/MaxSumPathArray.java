package com.sample.array;

/**
 * http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 */
public class MaxSumPathArray {

    public static void main(String[] args) {
        int[] a1 = { 2, 3, 7, 10, 12, 15, 30, 34 };
        int[] a2 = { 1, 5, 7, 8, 10, 15, 16, 19 };

        int result = maxSumPath(a1, a2);
        System.out.println(result);
    }

    private static int maxSumPath(int[] a1, int[] a2) {

        int sum = 0, sum1 = 0, sum2 = 0;
        int l1 = 0, l2 = 0;

        while (l1 < a1.length && l2 < a2.length) {
            if (a1[l1] == a2[l2]) {
                sum += Math.max(sum1, sum2);
                sum += a1[l1];
                sum1 = 0;
                sum2 = 0;
                l1++;
                l2++;
            }
            if (a1[l1] < a2[l2]) {
                sum1 += a1[l1];
                l1++;
            }
            if (a1[l1] > a2[l2]) {
                sum2 += a2[l2];
                l2++;
            }
        }
        while (l1 < a1.length) {
            sum1 += a1[l1];
            l1++;
        }
        while (l2 < a2.length) {
            sum2 += a2[l2];
            l2++;
        }
        return sum + Math.max(sum1, sum2);
    }
}
