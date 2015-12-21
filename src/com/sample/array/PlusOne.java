package com.sample.array;

import java.util.Arrays;

/**
 * PlusOne
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] digits = { 9, 9, 9, 9, 9, 9 };
        Integer[] result = new Integer[digits.length + 1];
        int carry = 0;
        for (int cnt = digits.length - 1; cnt >= 0; cnt--) {
            int sum = carry + digits[cnt];
            if (cnt == digits.length - 1)
                sum++;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            result[cnt + 1] = sum;
        }
        result[0] = carry;
        System.out.println(Arrays.asList(result).toString());
    }
}
