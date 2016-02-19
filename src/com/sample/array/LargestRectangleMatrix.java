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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int cLen = matrix[0].length; // column length
        int rLen = matrix.length; // row length
        // height array 
        int[] h = new int[cLen + 1];
        h[cLen] = 0;
        int max = 0;

        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < cLen + 1; i++) {
                if (i < cLen)
                    if (matrix[row][i] == 1)
                        h[i] += 1;
                    else
                        h[i] = 0;

                if (s.isEmpty() || h[s.peek()] <= h[i])
                    s.push(i);
                else {
                    while (!s.isEmpty() && h[i] < h[s.peek()]) {
                        int top = s.pop();
                        int area = h[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
                        if (area > max)
                            max = area;
                    }
                    s.push(i);
                }
            }
            System.out.println(Arrays.toString(h));
        }
        return max;
    }
}
