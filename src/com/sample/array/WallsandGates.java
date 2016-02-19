package com.sample.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sample.queue.Queue;

/**
 * TODO: Describe purpose and behavior of WallsandGates
 */
public class WallsandGates {

    public static void main(String[] args) {
        int[][] input = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

        bfs(input);
        System.out.println(Arrays.deepToString(input));
        int[][] i = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
        islands(i);

        int[][] ii = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 }, };
        islandsII(ii);
    }

    private static void islands(int[][] input) {
        int r = input.length;
        int c = input[0].length;
        int islands = 0;
        Queue<List<Integer>> queue = new Queue<>();
        for (int ii = 0; ii < r; ii++) {
            for (int jj = 0; jj < c; jj++) {
                if (input[ii][jj] == 1) {
                    islands++;
                    enqueue(ii, jj, queue);
                    while (!queue.isEmpty()) {
                        List<Integer> pos = queue.remove();
                        int i = pos.get(0);
                        int j = pos.get(1);

                        //if (input[i][j] == -1)
                        //    continue;
                        input[i][j] = -1; //visited
                        if (i > 0 && j > 0 && input[i - 1][j - 1] == 1) {
                            input[i - 1][j - 1] = -1;
                            enqueue(i - 1, j - 1, queue);
                        }
                        if (i > 0 && input[i - 1][j] == 1) {
                            input[i - 1][j] = -1;
                            enqueue(i - 1, j, queue);
                        }
                        if (i > 0 && j + 1 < c && input[i - 1][j + 1] == 1) {
                            input[i - 1][j + 1] = -1;
                            enqueue(i - 1, j + 1, queue);
                        }
                        if (j > 0 && input[i][j - 1] == 1) {
                            input[i][j - 1] = -1;
                            enqueue(i, j - 1, queue);
                        }
                        if (j + 1 < c && input[i][j + 1] == 1) {
                            input[i][j + 1] = -1;
                            enqueue(i, j + 1, queue);
                        }
                        if (i + 1 < r && j > 0 && input[i + 1][j - 1] == 1) {
                            input[i + 1][j - 1] = -1;
                            enqueue(i + 1, j - 1, queue);
                        }
                        if (i + 1 < r && input[i + 1][j] == 1) {
                            input[i + 1][j] = -1;
                            enqueue(i + 1, j, queue);
                        }
                        if (i + 1 < r && j + 1 < c && input[i + 1][j + 1] == 1) {
                            input[i + 1][j + 1] = -1;
                            enqueue(i + 1, j + 1, queue);
                        }
                    }
                }
            }
        }

        System.out.println(islands);
        System.out.println(Arrays.deepToString(input));
    }

    private static void islandsII(int[][] input) {
        int r = input.length;
        int c = input[0].length;
        int islands = 0;
        Queue<List<Integer>> queue = new Queue<>();
        for (int ii = 0; ii < r; ii++) {
            for (int jj = 0; jj < c; jj++) {
                if (input[ii][jj] == 1) {
                    islands++;
                    enqueue(ii, jj, queue);
                    while (!queue.isEmpty()) {
                        List<Integer> pos = queue.remove();
                        int i = pos.get(0);
                        int j = pos.get(1);

                        //if (input[i][j] == -1)
                        //    continue;
                        input[i][j] = -1; //visited
                        if (i > 0 && input[i - 1][j] == 1) {
                            input[i - 1][j] = -1;
                            enqueue(i - 1, j, queue);
                        }
                        if (j > 0 && input[i][j - 1] == 1) {
                            input[i][j - 1] = -1;
                            enqueue(i, j - 1, queue);
                        }
                        if (j + 1 < c && input[i][j + 1] == 1) {
                            input[i][j + 1] = -1;
                            enqueue(i, j + 1, queue);
                        }
                        if (i + 1 < r && input[i + 1][j] == 1) {
                            input[i + 1][j] = -1;
                            enqueue(i + 1, j, queue);
                        }
                    }
                }
            }
        }

        System.out.println(islands);
        System.out.println(Arrays.deepToString(input));
    }

    private static void bfs(int[][] input) {
        int r = input.length;
        int c = input[0].length;
        Queue<List<Integer>> queue = new Queue<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (input[i][j] == 0) {
                    enqueue(i, j, queue);
                }
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> pos = queue.remove();
            int i = pos.get(0);
            int j = pos.get(1);

            if (i > 0 && input[i - 1][j] == Integer.MAX_VALUE) {
                input[i - 1][j] = input[i][j] + 1;
                enqueue(i - 1, j, queue);
            }
            if (j + 1 < c && input[i][j + 1] == Integer.MAX_VALUE) {
                input[i][j + 1] = input[i][j] + 1;
                enqueue(i, j + 1, queue);
            }
            if (i + 1 < r && input[i + 1][j] == Integer.MAX_VALUE) {
                input[i + 1][j] = input[i][j] + 1;
                enqueue(i + 1, j, queue);
            }
            if (j > 0 && input[i][j - 1] == Integer.MAX_VALUE) {
                input[i][j - 1] = input[i][j] + 1;
                enqueue(i, j - 1, queue);
            }
        }

    }

    private static void enqueue(int i, int j, Queue<List<Integer>> queue) {
        List<Integer> pos = new ArrayList<>();
        pos.add(i);
        pos.add(j);
        queue.add(pos);
    }
}
