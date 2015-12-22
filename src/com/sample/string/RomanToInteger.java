package com.sample.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String input = "MXCVI";

        System.out.println(romanToInt(input));
        System.out.println(romanToInt("XL"));
    }

    private static int romanToInt(String roman) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('M', 1000);
        romanValues.put('D', 500);
        romanValues.put('C', 100);
        romanValues.put('L', 50);
        romanValues.put('X', 10);
        romanValues.put('V', 5);
        romanValues.put('I', 1);

        char[] romanChars = roman.toCharArray();
        int value = 0;
        int previous = 0;
        for (int cnt = 0; cnt < romanChars.length; cnt++) {
            int current = romanValues.get(romanChars[cnt]);
            value += current;
            if (current > previous) {
                value -= 2 * previous;
            }
            previous = current;
        }
        return value;
    }
}
