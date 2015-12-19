package com.sample.map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String input = "anagram";
        String anagram = "nagaram";
        System.out.println(validateAnagram(input, anagram));
    }

    private static boolean validateAnagram(String input, String anagram) {

        if (input == null || input.length() != anagram.length())
            return false;
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (int cnt = 0; cnt < input.length(); cnt++) {
            char inputChar = input.charAt(cnt);
            char anagramChar = anagram.charAt(cnt);
            if (inputChar == anagramChar)
                continue;
            else {
                if (anagramMap.containsKey(inputChar)) {
                    if (anagramMap.get(inputChar) + 1 == 0) {
                        anagramMap.remove(inputChar);
                    } else {
                        anagramMap.put(inputChar, anagramMap.get(inputChar) + 1);
                    }

                } else {
                    anagramMap.put(inputChar, 1);
                }

                if (anagramMap.containsKey(anagramChar)) {
                    if (anagramMap.get(anagramChar) - 1 == 0) {
                        anagramMap.remove(anagramChar);
                    } else {
                        anagramMap.put(anagramChar, anagramMap.get(anagramChar) - 1);
                    }
                } else {
                    anagramMap.put(anagramChar, -1);
                }
            }

        }
        return anagramMap.isEmpty();
    }
}
