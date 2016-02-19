package com.sample.array;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        trappingRainWater(input);
        trappingRainWaterII(input);
    }

    private static void trappingRainWaterII(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, maxarea = 0;
        while (i < input.length) {
            if (stack.isEmpty() || input[stack.peek()] >= input[i]) {
                stack.push(i++);
            } else {
                int bot = stack.pop();
                int area = stack.isEmpty() ? 0 : (Math.min(input[stack.peek()], input[i]) - input[bot])
                        * (i - stack.peek() - 1);
                maxarea += area;
            }
        }
        System.out.println(maxarea);
    }

    private static void trappingRainWater(int[] input) {
        int[] left = new int[input.length];
        int max = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (input[cnt] > max) {
                max = input[cnt];
            }
            left[cnt] = max;
        }
        max = 0;
        int[] right = new int[input.length];
        for (int cnt = input.length - 1; cnt >= 0; cnt--) {
            if (input[cnt] > max) {
                max = input[cnt];
            }
            right[cnt] = max;
        }
        int area = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            area += Math.min(left[cnt], right[cnt]) - input[cnt] < 0 ? 0 : Math.min(left[cnt], right[cnt]) - input[cnt];
        }
        System.out.println("Another area =>" + area);
    }
}
