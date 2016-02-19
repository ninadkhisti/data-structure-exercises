package com.sample.array;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of SubSortIndexes
 */
public class SubSortIndexes {

    public static void main(String[] args) {
        int[] input = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        List<Integer> result = subSortIndexes(input);
        System.out.println(result.toString());
    }

    private static List<Integer> subSortIndexes(int[] input) {
        int l = 0, r = 0;
        forloop: for (int cnt = 1; cnt < input.length; cnt++) {
            if (input[cnt] < input[cnt - 1]) {
                l = cnt - 1;
                break forloop;
            }
        }
        forrever: for (int cnt = input.length - 2; cnt >= 0; cnt--) {
            if (input[cnt] > input[cnt + 1]) {
                r = cnt + 1;
                break forrever;
            }
        }
        for (int cnt = l + 1; cnt < r; cnt++) {
            if (input[l] <= input[cnt] && input[r] >= input[cnt]) {
                continue;
            }
            while (l >= 0 && input[l] > input[cnt]) {
                l--;
            }
            while (r <= input.length - 1 && input[cnt] > input[r]) {
                r++;
            }

        }

        List<Integer> result = new ArrayList<>();
        result.add(l + 1);
        result.add(r - 1);
        return result;
    }
}
