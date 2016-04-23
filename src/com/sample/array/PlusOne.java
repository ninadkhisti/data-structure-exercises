package com.sample.array;

import java.util.Arrays;

/**
 * PlusOne
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] digits = { 9 };
        System.out.println(Arrays.toString(plusOne(digits)));
        /* Integer[] result = new Integer[digits.length + 1];
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
        */
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;

        int carry = 0, sum = 0, index = digits.length - 1;
        for (int cnt = digits.length - 1; cnt >= 0; cnt--) {
            sum = digits[cnt] + carry;
            if (cnt == digits.length - 1) {
                sum += 1;
            }
            digits[index--] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0)
            return digits;
        else {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            return result;
        }
    }
}
