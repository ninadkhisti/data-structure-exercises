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
        int previousPeak = 0, peak = 0;
        for (int cnt = 0; cnt < input.length - 1; cnt++) {
            if (input[cnt] > input[cnt + 1]) {
                if (cnt == 0 || input[cnt] >= peak) {
                    peak = input[cnt];
                }
            }
            if (peak != previousPeak && cnt > 0) {
                System.out.println("calculate => peak" + peak + " previous => " + previousPeak);
            }
            previousPeak = peak;
        }
    }
}
