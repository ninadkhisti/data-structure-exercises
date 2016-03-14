package com.sample.dynamicprogramming;

/**
 * TODO: Describe purpose and behavior of HouseRobber
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] input = { 4, 10, 3, 1, 5 };
        //int[] input = { 1 };
        int maxmoney = houseRobber(input);
        System.out.println(maxmoney);
    }

    private static int houseRobber(int[] input) {
        if (input == null || input.length == 0)
            return 0;

        int prev2 = 0;
        int prev1 = input[0];
        int max = input[0];
        for (int cnt = 1; cnt < input.length; cnt++) {
            int current = prev2 + input[cnt];
            max = Math.max(max, Math.max(current, prev1));

            prev2 = prev1;
            prev1 = max;
        }

        return max;
    }
}
