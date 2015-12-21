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

        for (int rotation = 0; rotation < k; rotation++) {
            int buffer = array[array.length - 1];
            for (int cnt = array.length - 1; cnt >= 1; cnt--) {
                array[cnt] = array[cnt - 1];
            }
            array[0] = buffer;
        }
        System.out.println(Arrays.asList(array).toString());
    }
}
