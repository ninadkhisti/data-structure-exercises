package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of ClimbingStairs
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbingStairs(n));
        System.out.println(climbingStairsWithoutMemory(n));
    }

    public static int climbingStairs(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;

        for (int cnt = 2; cnt < n; cnt++) {
            stairs[cnt] = stairs[cnt - 1] + stairs[cnt - 2];
        }
        System.out.println(Arrays.toString(stairs));
        return stairs[n - 1];
    }

    public static int climbingStairsWithoutMemory(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        int sum = 2, curr = 0, prev = 1;
        for (int cnt = 2; cnt < n; cnt++) {
            curr = sum;
            sum += prev;
            prev = curr;
        }
        return sum;
    }
}
