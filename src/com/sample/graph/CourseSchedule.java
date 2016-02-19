package com.sample.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> courses = new ArrayList<>();
        List<List<Integer>> edgelist = new ArrayList<>(n);
        for (int cnt = 0; cnt < n; cnt++) {
            edgelist.add(cnt, new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            edgelist.get(edge[1]).add(edge[0]);
        }
        System.out.println(edgelist.toString());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(edges[0][1]);
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            if (visited[node])
                return Collections.emptyList();
            else
                visited[node] = true;
            courses.add(node);
            List<Integer> dependents = edgelist.get(node);
            for (Integer dependent : dependents) {
                queue.add(dependent);
            }
            edgelist.get(node).removeAll(dependents);
        }

        return courses;
    }
}
