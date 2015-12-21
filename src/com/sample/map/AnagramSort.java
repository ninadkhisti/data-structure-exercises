package com.sample.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sort strings based on the anagrams
 */
public class AnagramSort {

    public static void main(String[] args) {
        String[] input = { "tacp", "tac", "pact", "act", "patc", "cat", "aptc" };

        List<String> sorted = anagramSorter(input);
        System.out.println(sorted.toString());
    }

    private static List<String> anagramSorter(String[] args) {
        List<String> result = new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (int cnt = 0; cnt < args.length; cnt++) {
            char[] inputChars = args[cnt].toCharArray();
            Arrays.sort(inputChars);
            String anagram = new String(inputChars);
            if (anagramMap.containsKey(anagram)) {
                anagramMap.get(anagram).add(args[cnt]);
            } else {
                List<String> anagramValues = new ArrayList<>();
                anagramValues.add(args[cnt]);
                anagramMap.put(anagram, anagramValues);
            }
        }

        for (String anagram : anagramMap.keySet()) {
            List<String> values = anagramMap.get(anagram);
            result.addAll(values);
        }

        return result;
    }
}
