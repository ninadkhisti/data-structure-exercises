package com.sample.dynamicprogramming;

/**
 * TODO: Describe purpose and behavior of CoinChange
 */
public class CoinChange {

    public static void main(String[] args) {
        int sum = 11;
        int[] coins = { 1, 2, 5 };
        int combinations = coinchange(coins, sum);
        System.out.println(combinations);
    }

    private static int coinchange(int[] coins, int sum) {
        if (sum <= 0)
            return -1;

        int[] combinations = new int[sum + 1];
        for (int cnt = 1; cnt <= sum; cnt++) {
            int min = -1;
            for (int coin : coins) {
                if (cnt >= coin && combinations[cnt - coin] != -1) {
                    int temp = combinations[cnt - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            combinations[cnt] = min;
        }

        return combinations[sum];
    }
}
