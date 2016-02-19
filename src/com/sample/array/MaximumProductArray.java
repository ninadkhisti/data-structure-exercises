package com.sample.array;

/**
 * TODO: Describe purpose and behavior of MaximumProductArray
 */
public class MaximumProductArray {

    public static void main(String[] args) {
        int[] input = { 2, 3, -2, 4, -1 };
        int product = maximumproduct(input);
        System.out.println(product);
    }

    private static int maximumproduct(int[] input) {
        if (input == null || input.length == 0)
            return 0;
        int min = input[0];
        int max = input[0];
        int product = Integer.MIN_VALUE;

        for (int cnt = 1; cnt < input.length; cnt++) {
            int temp = max;
            max = Math.max(Math.max(min * input[cnt], max * input[cnt]), input[cnt]);
            min = Math.min(Math.min(min * input[cnt], temp * input[cnt]), input[cnt]);
            if (max > product)
                product = max;
        }

        return product;
    }
}
