package com.sample.array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDupesFromSortedArray {

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11 };
        int previous = 0;
        int index = 0;
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (previous != array[cnt]) {
                array[index++] = array[cnt];
                previous = array[cnt];
            } else {
                continue;
            }
        }
        for (int cnt = index; cnt < array.length; cnt++) {
            array[cnt] = null;
        }
        System.out.println(Arrays.asList(array).toString());
    }
}
