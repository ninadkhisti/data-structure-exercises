package com.sample.array;

import java.util.Arrays;

import com.sample.stack.Stack;

/**
 * TODO: Describe purpose and behavior of LargestRectangleMatrix
 */
public class LargestRectangleMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 1, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 1 }, { 0, 1, 0, 0, 0 } };
        int[] input = { 2, 1, 5, 6, 2, 3 };
        int area = maxRectangleArea(matrix);
        System.out.println(area);
        System.out.println(largestRectangleHistogram(input));
    }

    private static int largestRectangleHistogram(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;
        for (int cnt = 0; cnt < input.length;) {
            if (stack.isEmpty() || input[stack.peek()] < input[cnt]) {
                stack.push(cnt);
                cnt++;
            } else {
                int top = stack.pop();
                int area = input[top] * (stack.isEmpty() ? cnt : cnt - stack.peek() - 1);
                if (area > maxarea)
                    maxarea = area;

            }
        }
        return maxarea;
    }

    private static int maxRectangleArea(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int maxArea = Integer.MIN_VALUE;
        int[] row = new int[matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < matrix[0].length + 1; j++) {
                if (j < matrix[0].length) {
                    row[j] = matrix[i][j] == 1 ? row[j] + 1 : 0;
                }
                if (stack.isEmpty() || row[stack.peek()] < row[j]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && row[stack.peek()] > row[j]) {
                        int top = stack.pop();
                        int area = row[top] * (stack.isEmpty() ? j : j - stack.peek() - 1);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            System.out.println(Arrays.toString(row));
        }
        return maxArea;
    }
}
