package com.sample.array;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDupesFromSortedArray {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11 };
        removeDupesfromArray(array);
        removeDupesFromArrayII(array);
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
            array[cnt] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    /**Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array nums = [1,1,2],

    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
    */
    private static void removeDupesfromArray(int[] input) {
        int index = 0;
        int previous = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (cnt == 0 || input[cnt] != previous) {
                input[index++] = input[cnt];
            }
            previous = input[cnt];
        }
        System.out.println("new array =>" + Arrays.toString(input));
    }

    /**Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array nums = [1,1,1,2,2,3],
    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
    */
    private static void removeDupesFromArrayII(int[] input) {
        int[] input1 = { 1, 1, 1, 2, 2, 3 };
        input = input1;
        int index = 0;
        int previous = 0;
        int repeatCount = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (input[cnt] == previous)
                repeatCount++;
            if (input[cnt] != previous)
                repeatCount = 0;
            if (cnt == 0 || repeatCount < 2) {
                input[index++] = input[cnt];
            }
            previous = input[cnt];
        }
        System.out.println("index => " + index);
        System.out.println("new array with atmost 2 dupes " + Arrays.toString(input));
    }
}
