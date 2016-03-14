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
        if (words == null || words.length == 0)
            return null;

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int cnt = 0; cnt < words.length; cnt++) {
            for (int i = 0; i < words[cnt].length(); i++) {
                char ch = words[cnt].charAt(i);
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new HashSet<Character>());
                }
            }

            if (cnt > 0) {
                connectGraph(graph, words[cnt - 1], words[cnt]);
            }
        }
        Map<Character, Integer> visited = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (Character vertex : graph.keySet()) {
            if (!topologicalSort(graph, visited, sb, vertex)) {
                return null;
            }
        }

        return sb.toString();
    }

    private static boolean topologicalSort(Map<Character, Set<Character>> graph, Map<Character, Integer> visited,
            StringBuffer sb, Character vertex) {

        if (visited.containsKey(vertex)) {
            if (visited.get(vertex) == -1) {
                return false;
            }
            if (visited.get(vertex) == 1) {
                return true;
            }
        }
        visited.put(vertex, -1);
        for (Character child : graph.get(vertex)) {
            if (!topologicalSort(graph, visited, sb, child)) {
                return false;
            }
        }

        visited.put(vertex, 1);
        sb.insert(0, vertex);
        return true;
    }

    private static void connectGraph(Map<Character, Set<Character>> graph, String previous, String current) {
        if (previous == null || previous.isEmpty() || current == null || current.isEmpty()) {
            return;
        }
        int minlength = previous.length() < current.length() ? previous.length() : current.length();

        for (int cnt = 0; cnt < minlength; cnt++) {
            if (previous.charAt(cnt) != current.charAt(cnt)) {
                graph.get(previous.charAt(cnt)).add(current.charAt(cnt));
                break;
            }
        }

    }
}
