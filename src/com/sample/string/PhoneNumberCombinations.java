package com.sample.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of PhoneNumberCombinations
 */
public class PhoneNumberCombinations {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(2, "abc");
        numbers.put(3, "def");
        numbers.put(4, "ghi");
        numbers.put(5, "jkl");
        numbers.put(6, "mno");
        numbers.put(7, "pqrs");
        numbers.put(8, "tuv");
        numbers.put(9, "wxyz");
        String number = "53678";
        phonecombinations(number, numbers, "", result);
        System.out.println(result.toString());
    }

    private static void phonecombinations(String number, Map<Integer, String> numbers, String curr, List<String> result) {
        if (number.length() == 0) {
            result.add(curr);
            return;
        }
        String n = number.substring(0, 1);
        String letters = numbers.get(Integer.parseInt(n));
        for (int cnt = 0; cnt < letters.length(); cnt++) {
            char c = letters.charAt(cnt);
            phonecombinations(number.substring(1), numbers, curr.concat(Character.toString(c)), result);
        }

    }
}
