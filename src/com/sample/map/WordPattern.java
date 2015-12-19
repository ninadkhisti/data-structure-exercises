package com.sample.map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * 
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String input = "dog cat cat fish";

        System.out.println(matchWordPattern(pattern, input));
    }

    private static boolean matchWordPattern(String pattern, String input) {
        String[] inputArray = input.split(" ");

        if (pattern.length() != inputArray.length)
            return false;
        Map<Character, String> existingPattern = new HashMap<>();
        for (int cnt = 0; cnt < pattern.length(); cnt++) {
            if (existingPattern.containsKey(pattern.charAt(cnt))) {
                if (inputArray[cnt].equals(existingPattern.get(pattern.charAt(cnt)))) {
                    continue;
                } else {
                    return false;
                }
            } else {
                existingPattern.put(pattern.charAt(cnt), inputArray[cnt]);
            }
        }
        return true;
    }
}
