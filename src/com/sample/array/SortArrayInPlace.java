package com.sample.array;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of SortArrayInPlace
 */
public class SortArrayInPlace {

    public static void main(String[] args) {
        int[] input = { 2, 0, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 2, 2, 0, 1, 2 };
        int[] product = { 1, 2, 3, 4, 5 };
        productExceptSelf(product);
        sortInplace(input);
    }

    private static void productExceptSelf(int[] product) {
        int[] result = new int[product.length];
        result[0] = 1;
        for (int cnt = 1; cnt < product.length; cnt++) {
            result[cnt] = product[cnt - 1] * result[cnt - 1];
        }
        int iprod = 1;
        for (int cnt = product.length - 2; cnt >= 0; cnt--) {
            iprod *= product[cnt + 1];
            result[cnt] = result[cnt] * iprod;
        }
        System.out.println(Arrays.toString(result));

    }

    private static void sortInplace(int[] input) {
        int start = 0;
        int end = input.length - 1;

        int index = 0;
        while (index <= end) {
            if (input[index] == 0) {
                int temp = input[start];
                input[start] = 0;
                input[index] = temp;
                start++;
                //index++;
            } else if (input[index] == 2) {
                int temp = input[end];
                input[end] = 2;
                input[index] = temp;
                end--;
            } else {
                index++;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
