package com.sample.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO: Describe purpose and behavior of GraphConnectecComponents
 */
public class GraphConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 } };

        int components = connectedComponents(5, edges);
        System.out.println(components);
        int[][] courses = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        List<Integer> result = courses(4, courses);
        System.out.println(result.toString());
    }

    private static int connectedComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int cnt = 0; cnt < n; cnt++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int comp = 0;

        for (int cnt = 0; cnt < n; cnt++) {
            if (visited[cnt])
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(cnt);
            comp++;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited[node] = true;

                for (Integer neigh : graph.get(node)) {
                    queue.add(neigh);
                    graph.get(neigh).remove((Integer) node);
                }
            }
        }
        return comp;
    }

    private static List<Integer> courses(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> courses = new ArrayList<>();
        for (int cnt = 0; cnt < n; cnt++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(edges[0][1]);
        courses.add(edges[0][1]);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node])
                return null;
            visited[node] = true;
            for (int neighbour : graph.get(node)) {
                queue.add(neighbour);
                courses.add(neighbour);
            }
        }
        return courses;
    }
}
