package com.sample.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of WordBreak
 */
public class WordBreak {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> result = wordBreak("catsanddog", dict, new HashMap<String, List<String>>());
        List<String> naive = new ArrayList<>();
        List<String> current = new ArrayList<>();
        wordBreakNaive("catsanddog", dict, naive, current);
        //System.out.println(result.toString());
        System.out.println(naive.toString());
        System.out.println(current.toString());
    }

    private static void wordBreakNaive(String input, Set<String> dict, List<String> result, List<String> current) {
        if (input.isEmpty()) {
            if (!current.isEmpty()) {
                List<String> temp = new ArrayList<>(current);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.size(); i++) {
                    sb.append(temp.get(i));
                    if (i != temp.size() - 1) {
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
                return;
            }
            return;
        }
        for (String word : dict) {
            if (input.startsWith(word)) {
                current.add(word);
                wordBreakNaive(input.substring(word.length()), dict, result, current);
                current.remove(current.size() - 1);
            }
        }

    }

    private static List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> words = new ArrayList<>();
        if (s.isEmpty()) {
            words.add("");
            return words;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> wordResult = wordBreak(s.substring(word.length()), dict, map);
                for (String aResult : wordResult) {
                    words.add((word + (aResult.isEmpty() ? "" : " ") + aResult));
                }
            }

        }
        map.put(s, words);
        return words;
    }
}
