package com.sample.array;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of MinArrayIndex
 */
public class MinArrayIndex {

    public static void main(String[] args) {
        int[] a1 = { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 };
        int[] a2 = { 1, 5, 9 };
        List<Integer> indexes = findminindexes(a1, a2);
        System.out.println(indexes.toString());
    }

    private static List<Integer> findminindexes(int[] a1, int[] a2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int[] freq = new int[a2.length];
        int minlength = Integer.MAX_VALUE;
        int begin = 0, end = 0;
        while (i < a1.length && j < a1.length) {
            if (!match(freq)) {
                updateFreq(a1[j], a2, freq, true);
                j++;
            } else {
                if (j - i < minlength) {
                    minlength = Math.min(minlength, j - i);
                    end = j;
                    begin = i;
                }
                updateFreq(a1[i], a2, freq, false);
                i++;
            }
        }
        result.add(begin);
        result.add(end - 1);
        return result;
    }

    private static void updateFreq(int i, int[] a2, int[] freq, boolean increase) {
        for (int cnt = 0; cnt < a2.length; cnt++) {
            if (a2[cnt] == i && increase)
                freq[cnt]++;
            if (a2[cnt] == i && !increase)
                freq[cnt]--;
        }

    }

    private static boolean match(int[] a2) {
        for (int cnt = 0; cnt < a2.length; cnt++) {
            if (a2[cnt] < 1)
                return false;
        }
        return true;
    }
}
