package com.sample.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO: Describe purpose and behavior of ShortestDistanceFromBuildings
 */
public class ShortestDistanceFromBuildings {

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        System.out.println(shortestDistance(grid));
    }

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int r = grid.length, c = grid[0].length;
        int[][] distance = new int[r][c];
        int[][] reachable = new int[r][c];
        int mindistance = Integer.MAX_VALUE;
        int buildings = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int d = 0;
                    buildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[r][c];
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int size = queue.size();

                        for (int k = 0; k < size; k++) {
                            int[] point = queue.poll();
                            int x = point[0], y = point[1];
                            visited[x][y] = true;
                            distance[x][y] += d;
                            reachable[x][y]++;

                            if (x > 0 && !visited[x - 1][y] && grid[x - 1][y] == 0) {
                                queue.add(new int[] { x - 1, y });
                                visited[x - 1][y] = true;
                            }
                            if (x < r - 1 && !visited[x + 1][y] && grid[x + 1][y] == 0) {
                                queue.add(new int[] { x + 1, y });
                                visited[x + 1][y] = true;
                            }
                            if (y > 0 && !visited[x][y - 1] && grid[x][y - 1] == 0) {
                                queue.add(new int[] { x, y - 1 });
                                visited[x][y - 1] = true;
                            }
                            if (y < c - 1 && !visited[x][y + 1] && grid[x][y + 1] == 0) {
                                queue.add(new int[] { x, y + 1 });
                                visited[x][y + 1] = true;
                            }
                        }
                        d++;
                    }

                }
            }
        }
        System.out.println(Arrays.deepToString(distance));
        System.out.println(Arrays.deepToString(reachable));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 && reachable[i][j] == buildings) {
                    mindistance = Math.min(mindistance, distance[i][j]);
                }
            }
        }
        return mindistance;
    }
}
