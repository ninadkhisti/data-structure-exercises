package com.sample.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of RemoveDuplicateLetters
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println(removeDuplicateLetters(input));
        System.out.println(removeDuplicateLettersII(input));
    }

    private static String removeDuplicateLettersII(String input) {
        if (input == null || input.isEmpty())
            return null;

        List<Character> chars = new ArrayList<>();
        Map<Character, List<Integer>> charMap = new HashMap<>();
        for (int cnt = 0; cnt < input.length(); cnt++) {
            char ch = input.charAt(cnt);
            if (!charMap.containsKey(ch)) {
                charMap.put(ch, new ArrayList<Integer>());
                chars.add(ch);
            }
            charMap.get(ch).add(cnt);
        }
        System.out.println(charMap.toString());
        System.out.println(chars.toString());
        Collections.sort(chars);
        StringBuilder sb = new StringBuilder();
        while (!charMap.isEmpty()) {
            boolean found = true;
            for (int i = 0; i < chars.size(); i++) {
                int index = charMap.get(chars.get(i)).get(0);
                forl1: for (int j = 0; j < chars.size(); j++) {
                    List<Integer> counts = charMap.get(chars.get(j));
                    if (counts.get(counts.size() - 1) < index) {
                        found = false;
                        break forl1;
                    }
                }
                if (found) {
                    sb.append(chars.get(i));
                    charMap.remove(chars.get(i));
                    chars.remove(i);
                    for (int j = 0; j < chars.size(); j++) {
                        List<Integer> counts = charMap.get(chars.get(j));
                        while (counts.get(0) < index) {
                            counts.remove(0);
                        }
                    }
                    break;
                }
                found = true;
            }
        }

        return sb.toString();
    }

    private static String removeDuplicateLetters(String input) {
        if (input == null || input.isEmpty())
            return null;

        int[] alphabets = new int[26];
        for (int cnt = 0; cnt < input.length(); cnt++) {
            alphabets[input.charAt(cnt) - 'a']++;
        }
        String result = "";
        for (int cnt = 0; cnt < alphabets.length; cnt++) {
            if (alphabets[cnt] > 0)
                result += (char) (cnt + 'a');
        }

        return result;
    }
}
