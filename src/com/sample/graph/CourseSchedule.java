package com.sample.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of CourseSchedule
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] edges = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        List<Integer> result = courseschedule(edges, 4);
        System.out.println(result.toString());
    }

    private static List<Integer> courseschedule(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> children = new HashSet<>();
                children.add(edge[0]);
                graph.put(edge[1], children);
            }
        }
        System.out.println(graph.toString());
        Map<Integer, Integer> visited = new HashMap<>();
        List<Integer> courses = new ArrayList<>();
        for (Integer vertex : graph.keySet()) {
            if (!topologicalSort(graph, visited, courses, vertex)) {
                return null;
            }
        }
        return courses;
    }

    private static boolean topologicalSort(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> visited,
            List<Integer> courses, Integer vertex) {
        if (visited.containsKey(vertex)) {
            if (visited.get(vertex) == -1) {
                return false;
            }
            if (visited.get(vertex) == 1) {
                return true;
            }
        } else {
            visited.put(vertex, -1);
        }
        if (graph.get(vertex) != null) {
            for (Integer child : graph.get(vertex)) {
                if (!topologicalSort(graph, visited, courses, child)) {
                    return false;
                }
            }
        }
        courses.add(0, vertex);
        visited.put(vertex, 1);
        return true;
    }
}
