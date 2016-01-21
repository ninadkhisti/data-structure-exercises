package com.sample.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] input1 = { 2, 3, -2, 4 };
        maximumSumSubarray(input);
        maximumProductSubarray(input1);
        largestRectangleAreaHistogram();
        largestRectangleAreaHistogramII();
    }

    private static void largestRectangleAreaHistogram() {
        int[] histogram = { 6, 2, 5, 4, 5, 1, 3 };//{ 2, 1, 5, 6, 2, 3 };
        int[] differentialHisto = new int[histogram.length];

        differentialHisto[0] = 0;
        for (int cnt = 1; cnt < histogram.length; cnt++) {
            differentialHisto[cnt] = histogram[cnt] - histogram[cnt - 1];
        }
        System.out.println(Arrays.toString(differentialHisto));
        int maxSum = 0, sum = 0;
        int beginIndex = 0, endIndex = 0;
        int bIndex = 0;
        for (int cnt = 0; cnt < differentialHisto.length; cnt++) {
            sum += differentialHisto[cnt];
            if (sum > maxSum) {
                maxSum = sum;
                bIndex = beginIndex;
                endIndex = cnt;
            }
            if (sum < 0) {
                sum = 0;
                beginIndex = cnt + 1;
            }
        }
        int min = histogram[bIndex];
        for (int cnt = bIndex + 1; cnt < endIndex; cnt++) {
            min = Math.min(min, histogram[cnt]);
        }
        System.out.println("area =>" + (min * (endIndex + 1 - bIndex)));
    }

    private static void largestRectangleAreaHistogramII() {
        int[] height = { 6, 2, 5, 4, 5, 1, 3 };//{ 2, 1, 5, 6, 2, 3 };
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        System.out.println("max area" + maxArea);

    }

    private static void maximumSumSubarray(int[] input) {
        int sum = 0, maxSum = 0;
        int startIndex = 0, endIndex = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {
            sum += input[cnt];
            if (sum > maxSum) {
                maxSum = sum;
                endIndex = cnt;
            }
            if (sum < 0) {
                sum = 0;
                startIndex = cnt + 1;
            }
        }
        System.out.println("Max sum =>" + maxSum);
        System.out.println("Start Index =>" + startIndex);
        System.out.println("End Indexs =>" + endIndex);
    }

    private static void maximumProductSubarray(int[] input) {
        int product = 0, maxProduct = 0;
        int startIndex = 0, endIndex = 0;

        for (int cnt = 1; cnt < input.length; cnt++) {
            product = input[cnt] * input[cnt - 1];

            if (maxProduct < product) {
                maxProduct = product;
                endIndex = cnt;
            }
            if (product < 0) {
                product = 0;
                startIndex = cnt;
            }
        }
        System.out.println("max product =>" + maxProduct + " start " + (startIndex - 1) + " end " + (endIndex - 1));
    }
}
