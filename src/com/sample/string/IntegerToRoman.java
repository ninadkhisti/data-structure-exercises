package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        int number = 3998;

        System.out.println(intToRoman(number));
    }

    private static String intToRoman(int number) {
        List<Integer> romans = new ArrayList<>();
        romans.add(1000);
        romans.add(900);
        romans.add(500);
        romans.add(400);
        romans.add(100);
        romans.add(90);
        romans.add(50);
        romans.add(40);
        romans.add(10);
        romans.add(9);
        romans.add(5);
        romans.add(4);
        romans.add(1);

        List<String> romanValues = new ArrayList<>();
        romanValues.add("M");
        romanValues.add("CM");
        romanValues.add("D");
        romanValues.add("CD");
        romanValues.add("C");
        romanValues.add("XC");
        romanValues.add("L");
        romanValues.add("XL");
        romanValues.add("X");
        romanValues.add("IX");
        romanValues.add("V");
        romanValues.add("IV");
        romanValues.add("I");

        String result = "";
        while (number > 0) {
            int index = 0;
            for (Integer value : romans) {
                int letter = number / value;
                for (int cnt = 0; cnt < letter; cnt++) {
                    result = result.concat(romanValues.get(index));
                }
                number -= letter * value;
                index++;
            }
        }
        return result;
    }
}
