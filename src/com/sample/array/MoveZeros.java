package com.sample.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].s
 */
public class MoveZeros {

    public static void main(String[] args) {
        Integer[] array = { 0, 1, 0, 3, 12 };
        int index = 0;
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (array[cnt] == 0) {
                continue;
            }
            array[index++] = array[cnt];
        }
        for (int cnt = index; cnt < array.length; cnt++) {
            array[cnt] = 0;
        }
        System.out.println(Arrays.asList(array).toString());
    }
}
