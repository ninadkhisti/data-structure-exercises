package com.sample.array;

import java.util.Arrays;

/**
 * Rotate Array by k numbers
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateArray(array, k);

        for (int rotation = 0; rotation < k; rotation++) {
            int buffer = array[array.length - 1];
            for (int cnt = array.length - 1; cnt >= 1; cnt--) {
                array[cnt] = array[cnt - 1];
            }
            array[0] = buffer;
        }
        System.out.println(Arrays.asList(array).toString());

    }

    private static void rotateArray(Integer[] array, int k) {
        k = array.length - k;
        reverseArray(array, 0, k - 1);
        reverseArray(array, k, array.length - 1);
        reverseArray(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void reverseArray(Integer[] array, int l, int r) {
        while (l < r) {
            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }

}
