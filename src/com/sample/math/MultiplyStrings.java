package com.sample.math;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of MultiplyStrings
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        String s1 = "8935";
        String s2 = "7845";
        String result = multiply(s1, s2);
        System.out.println(result);
    }

    //concerns integer overflow, s1 or s2 null empty, s1 or s2 equal to 0, s1 or s2 negative or invalid String.
    private static String multiply(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return "0";

        int[] digits = new int[s1.length() + s2.length()];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int d1 = s1.charAt(i) - '0';
                int d2 = s2.charAt(j) - '0';
                digits[i + j + 1] += d1 * d2;
            }
        }
        System.out.println(Arrays.toString(digits));
        int carry = 0;
        for (int cnt = digits.length - 1; cnt >= 0; cnt--) {
            int tmp = (digits[cnt] + carry) % 10;
            carry = (digits[cnt] + carry) / 10;
            digits[cnt] = tmp;
        }

        System.out.println(Arrays.toString(digits));
        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < digits.length; cnt++) {
            sb = sb.append(digits[cnt]);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();

    }
}
