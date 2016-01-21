package com.sample.string;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of PalindromePermutation
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String input = "ccdde";

        boolean result = palindromePermutaion(input);
        System.out.println(result);
    }

    private static boolean palindromePermutaion(String input) {
        char[] array = input.toCharArray();
        Arrays.sort(array);
        boolean oddcount = false;
        int count = 1;
        for (int cnt = 1; cnt < array.length; cnt++) {
            if (array[cnt - 1] == array[cnt]) {
                count++;
            } else {
                if (count % 2 == 1) {
                    if (oddcount) {
                        return false;
                    } else {
                        oddcount = true;
                    }
                }
                count = 1;
            }
        }

        return true;
    }
}
