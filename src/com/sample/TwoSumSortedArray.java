package com.sample;

/**
 * TwoSum with sorted array
 */
public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 20 };
        int sum = 10;

        outer: for (int ocnt = 0; ocnt < arr.length; ocnt++) {
            inner: for (int icnt = ocnt + 1; icnt < arr.length; icnt++) {
                System.out.println(arr[ocnt] + " " + arr[icnt]);
                if (arr[ocnt] + arr[icnt] == sum) {
                    System.out.println("index1 " + ocnt + " index2 " + icnt);
                    break outer;
                }
                if (arr[ocnt] + arr[icnt] > sum) {
                    break inner;
                }
            }
        }

    }
}
