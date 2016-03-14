package com.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of AlphabeticalOrder
 */
public class AlphabeticalOrder {

    public static void main(String[] args) {
        String[] input = { "ccda", "ccbk", "cd", "a", "ab" };
        System.out.println("Order = > " + alphabeticalOrder(input));
    }

    private static String alphabeticalOrder(String[] input) {
        if (input == null || input.length == 0)
            return null;

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            String word = input[cnt];
            for (int i = 0; i < word.length(); i++) {
                if (!graph.containsKey(word.charAt(i))) {
                    graph.put(word.charAt(i), new HashSet<Character>());
                }
                if (cnt > 0) {
                    connectGraph(graph, input[cnt - 1], word);
                }
            }
        }
        System.out.println(graph.toString());

        Map<Character, Integer> visited = new HashMap<>();
        StringBuffer sb = new StringBuffer();

        for (Character vertex : graph.keySet()) {
            if (!topologicalSort(graph, visited, vertex, sb)) {
                return null;
            }
        }
        return sb.toString();
    }

    private static boolean topologicalSort(Map<Character, Set<Character>> graph, Map<Character, Integer> visited,
            Character vertex, StringBuffer sb) {

        if (visited.containsKey(vertex)) {
            if (visited.get(vertex) == -1) { //again visiting
                return false;
            }
            if (visited.get(vertex) == 1) { //already visited
                return true;
            }
        }
        visited.put(vertex, -1); //visiting 

        for (Character neighbour : graph.get(vertex)) {
            if (!topologicalSort(graph, visited, neighbour, sb)) {
                return false;
            }
        }

        visited.put(vertex, 1); // visited
        sb.insert(0, vertex);
        return true;
    }

    private static void connectGraph(Map<Character, Set<Character>> graph, String previous, String current) {
        if (previous == null || previous.isEmpty() || current == null || current.isEmpty())
            return;

        int minlength = previous.length() < current.length() ? previous.length() : current.length();
        for (int i = 0; i < minlength; i++) {
            if (previous.charAt(i) != current.charAt(i)) {
                graph.get(previous.charAt(i)).add(current.charAt(i));
                break;
            }
        }
        //return;
    }
}
