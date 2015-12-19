package com.sample.map;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class DuplicatedInArray {

    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10 };
        int[] array1 = { 1, 2, 3, 4, 5, 6, 10, 8, 9, 9, 10 };
        System.out.println(containDuplicates(array));
        System.out.println(containDuplicatesII(array1));
    }

    private static boolean containDuplicatesII(int[] array) {

        int k = 4;
        if (k > array.length || k < 0)
            return false;
        if (k == 0)
            return true;

        for (int cnt = 0; cnt < array.length - k; cnt++) {
            if (array[cnt] == array[cnt + k]) {
                return true;
            }
        }

        return false;
    }

    private static boolean containDuplicates(int[] array) {
        Set<Integer> uniqueSet = new HashSet<>(array.length);
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (uniqueSet.contains(array[cnt])) {
                return true;
            }
            uniqueSet.add(array[cnt]);
        }
        return false;
    }
}
