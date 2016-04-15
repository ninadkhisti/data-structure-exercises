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
        wordBreak("catsanddog", dict, naive, current);
        //System.out.println(result.toString());
        System.out.println(naive.toString());
        System.out.println(current.toString());
    }

    private static void wordBreak(String input, Set<String> dict, List<String> naive, List<String> current) {
        if (input.isEmpty() && !current.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int cnt = 0; cnt < current.size(); cnt++) {
                sb.append(current.get(cnt));
                if (cnt != current.size() - 1) {
                    sb.append(" ");
                }
            }
            naive.add(sb.toString());
            return;
        }
        for (String word : dict) {
            if (input.startsWith(word)) {
                current.add(word);
                wordBreak(input.substring(word.length()), dict, naive, current);
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
