package com.sample.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of AlienOrder
 */
public class AlienOrder {

    public static void main(String[] args) {
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        String order = alienOrder(words);
        System.out.println("Order => " + order);
    }

    private static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int cnt = 0; cnt < words.length; cnt++) {
            for (int i = 0; i < words[cnt].length(); i++) {
                if (!graph.containsKey(words[cnt].charAt(i))) {
                    graph.put(words[cnt].charAt(i), new HashSet<Character>());
                }
            }
            if (cnt > 0) {
                connectGraph(graph, words[cnt - 1], words[cnt]);
            }
        }
        System.out.println(graph.toString());
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> visited = new HashMap<>();
        for (Character c : graph.keySet()) {
            if (!topologicalSort(graph, sb, visited, c)) {
                return "";
            }
        }

        return sb.toString();
    }

    private static boolean topologicalSort(Map<Character, Set<Character>> graph, StringBuffer sb,
            Map<Character, Integer> visited, Character c) {
        if (visited.containsKey(c)) {
            if (visited.get(c) == -1) {
                return false;
            }
            if (visited.get(c) == 1) {
                return true;
            }
        } else {
            visited.put(c, -1);
        }
        for (Character child : graph.get(c)) {
            if (!topologicalSort(graph, sb, visited, child)) {
                return false;
            }
        }

        sb.insert(0, c);
        visited.put(c, 1);
        return true;
    }

    private static void connectGraph(Map<Character, Set<Character>> graph, String prev, String curr) {
        if (prev == null || prev.length() == 0 || curr == null || curr.length() == 0) {
            return;
        }
        int minlength = prev.length() < curr.length() ? prev.length() : curr.length();
        for (int cnt = 0; cnt < minlength; cnt++) {
            char p = prev.charAt(cnt);
            char q = curr.charAt(cnt);
            if (p != q) {
                if (!graph.get(p).contains(q)) {
                    graph.get(p).add(q);
                    break;
                }
            }
        }
    }
}
