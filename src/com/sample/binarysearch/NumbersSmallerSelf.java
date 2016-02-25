package com.sample.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of NumbersSmallerSelf
 */
public class NumbersSmallerSelf {

    public static void main(String[] args) {
        int[] input = { 5, 2, 6, 1 };
        int[] result = numbersmallerright(input);
        System.out.println(Arrays.toString(result));
    }

    private static int[] numbersmallerright(int[] input) {
        int[] result = new int[input.length];
        List<Integer> sorted = new ArrayList<>();
        for (int cnt = input.length - 1; cnt >= 0; cnt--) {
            int index = sortedIndex(sorted, input[cnt]);
            sorted.add(index, input[cnt]);
            result[cnt] = index;
            System.out.println(sorted.toString());
        }
        return result;
    }

    private static int sortedIndex(List<Integer> sorted, int i) {
        if (sorted.isEmpty())
            return 0;
        int l = 0, r = sorted.size() - 1;
        if (i < sorted.get(l))
            return 0;
        if (i > sorted.get(r))
            return r + 1;
        while (l < r) {
            int mid = (l + r) / 2;

        }
        return 0;
    }
}
