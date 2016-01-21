package com.sample.array;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of ConsecutiveArrayElements
 */
public class ConsecutiveArrayElements {

    public static void main(String[] args) {
        int[] input = { 7, 6, 5, 5, 3, 4 };
        boolean result = consecutiveElements(input);
        boolean result1 = consecutiveElementsII(input);
        System.err.println(result);
        System.err.println(result1);
    }

    private static boolean consecutiveElementsII(int[] input) {
        Arrays.sort(input);
        int min = input[0];
        int max = input[input.length - 1];
        if (max - min == input.length - 1)
            return true;
        return false;
    }

    private static boolean consecutiveElements(int[] input) {
        int min = input[0], max = input[0];

        for (int cnt = 1; cnt < input.length; cnt++) {
            if (input[cnt] < min) {
                min = input[cnt];
            }
            if (input[cnt] > max) {
                max = input[cnt];
            }
        }
        int[] visited = new int[max - min + 1];

        for (int cnt = 0; cnt < input.length; cnt++) {
            if (visited[input[cnt] - min] != 0) {
                return false;
            }
            visited[input[cnt] - min] = 1;
        }
        return true;
    }
}
