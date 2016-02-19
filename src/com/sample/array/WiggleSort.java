package com.sample.array;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of WiggleSort
 */
public class WiggleSort {

    public static void main(String[] args) {

        int[] input = { 1, 5, 1, 1, 6, 4 };
        wiggleSort(input);
    }

    private static void wiggleSort(int[] input) {
        for (int cnt = 1; cnt < input.length; cnt = cnt + 2) {
            if (input[cnt - 1] > input[cnt]) { //swap
                int temp = input[cnt];
                input[cnt] = input[cnt - 1];
                input[cnt - 1] = temp;
            }
            if (cnt + 1 < input.length && input[cnt] < input[cnt + 1]) { //swap
                int temp = input[cnt + 1];
                input[cnt + 1] = input[cnt];
                input[cnt] = temp;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
