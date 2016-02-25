package com.sample.binaryindextree;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of BinaryIndexTree
 */
public class BinaryIndexTree {

    public static void main(String[] args) {
        int input[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString(input));
        int[] bit = constructBIT(input);

        System.out.println(getSum(bit, 6));
        System.out.println(getSum(bit, 9));
        System.out.println(6 & -6);
        System.out.println(1 & -1);
        System.out.println(4 & -4);
        System.out.println(9 & -9);
    }

    private static int[] constructBIT(int[] input) {
        int[] bit = new int[input.length + 1];
        for (int cnt = 0; cnt < input.length; cnt++) {
            updateBIT(bit, input.length, cnt, input[cnt]);
        }
        System.out.println(Arrays.toString(bit));
        return bit;
    }

    private static void updateBIT(int[] bit, int length, int index, int val) {
        index = index + 1;

        while (index <= length) {
            // Add 'val' to current node of BI Tree
            bit[index] += val;
            index += index & ~(index - 1);
        }
    }

    private static int getSum(int[] bit, int index) {
        int sum = 0;
        index = index + 1;
        while (index > 0) {
            sum += bit[index];
            index -= index & ~(index - 1);
        }
        return sum;
    }
}
