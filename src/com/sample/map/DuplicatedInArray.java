package com.sample.map;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class DuplicatedInArray {

    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //int[] array1 = { 1, 2, 3, 4, 5, 6, 10, 8, 9, 9, 10 };
        int[] array1 = { -1, 2147483647 };
        System.out.println(containDuplicates(array));
        System.out.println(containDuplicatesII(array1, 4));
        System.out.println(containDuplicatesIII(array1, 1, 2147483647));
    }

    private static boolean containDuplicatesIII(int[] array, int k, int t) {
        if (array == null || array.length <= 1 || t < 0 || k < 1)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            if (i > k)
                set.remove(array[i - k - 1]);
            long lowerbound = Math.min((long) array[i] - t, (long) array[i] + t);
            long upperbound = Math.max((long) array[i] - t, (long) array[i] + t);
            Set<Long> subset = set.subSet(lowerbound, true, upperbound, true);
            if (!subset.isEmpty())
                return true;
            else
                set.add((long) array[i]);
        }
        return false;
    }

    private static boolean containDuplicatesII(int[] input, int k) {
        if (input == null || input.length <= 1 || k <= 0)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (cnt > k)
                set.remove(input[cnt - k - 1]);
            if (!set.add(input[cnt])) {
                return true;
            }
        }

        return false;
    }

    private static boolean containDuplicates(int[] array) {
        if (array == null || array.length == 0)
            return false;
        Set<Integer> uniqueSet = new HashSet<>(array.length);
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (!uniqueSet.add(array[cnt])) {
                return false;
            }
        }
        return true;
    }
}
