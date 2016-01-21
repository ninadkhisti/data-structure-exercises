package com.sample.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(input);
        System.out.println(result.toString());
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> resultMap = new HashMap<>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            String anagram = input[cnt];
            char[] anagramKey = anagram.toCharArray();
            Arrays.sort(anagramKey);
            String anagramKeyStr = new String(anagramKey);
            if (resultMap.containsKey(anagramKeyStr)) {
                resultMap.get(anagramKeyStr).add(anagram);
            } else {
                List<String> values = new ArrayList<>();
                values.add(anagram);
                resultMap.put(anagramKeyStr, values);
            }

        }
        for (String key : resultMap.keySet()) {
            List<String> values = resultMap.get(key);
            result.add(values);
        }

        return result;
    }
}
