package com.sample.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO: Describe purpose and behavior of GraphValidTree
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        //int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        int n = 5;
        boolean result = validTree(edges, n);
        System.out.println(result);
    }

    private static boolean validTree(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int cnt = 0; cnt < n; cnt++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node] == true)
                return false;
            visited[node] = true;

            for (Integer neigh : graph.get(node)) {
                queue.add(neigh);
                graph.get(neigh).remove((Integer) node);
            }
        }

        for (boolean visit : visited) {
            if (!visit)
                return false;
        }
        return true;
    }
}
