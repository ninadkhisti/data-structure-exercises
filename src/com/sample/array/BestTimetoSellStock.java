package com.sample.array;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class BestTimetoSellStock {

    public static void main(String[] args) {
        int[] input = { 4, 5, 7, 8, 9, 27, 2, 3, 10, 12, 13 };
        bestTimetoSellStock(input);
        bestTimetoSellStockI(input);
        bestTimetoSellStockII(input);
        bestTimetoSellStock2(input);
        bestTimetoSellStock();
        bestTimetoSellStockKTrans();
        bestTimetoSellStockWithCooldown();
    }

    private static void bestTimetoSellStockWithCooldown() {
        int[] input = { 1, 2, 3, 0, 2 };
        int[] s0 = new int[input.length];
        int[] s1 = new int[input.length];
        int[] s2 = new int[input.length];

        s0[0] = 0;
        s1[0] = -input[0];
        s2[0] = Integer.MIN_VALUE;
        for (int cnt = 1; cnt < input.length; cnt++) {
            s0[cnt] = Math.max(s0[cnt - 1], s2[cnt - 1]);
            s1[cnt] = Math.max(s1[cnt - 1], s0[cnt - 1] - input[cnt]);
            s2[cnt] = s1[cnt - 1] + input[cnt];
        }
        int maxProfit = Math.max(s0[s0.length - 1], s2[s2.length - 1]);
        System.out.println("coooldown = >" + maxProfit);
    }

    private static void bestTimetoSellStockKTrans() {
        int[] price = { 2, 30, 15, 10, 8, 25, 80 };
        int k = 2;
        int n = price.length - 1;
        if (price == null || price.length <= 1)
            System.out.println("0");

        if (k >= n / 2) {
            int maxprofit = 0;
            for (int i = 1; i <= n; i++) {
                if (price[i] > price[i - 1])
                    maxprofit += price[i] - price[i - 1];
            }
            System.out.println(maxprofit);
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localmax = dp[i - 1][0] - price[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], price[j] + localmax);
                localmax = Math.max(localmax, dp[i - 1][j] - price[j]);
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }

    private static void bestTimetoSellStock() {
        // at most two transactions
        int[] price = { 2, 30, 15, 10, 8, 25, 80 };
        int[] profit = new int[price.length];

        int max_sell = price[price.length - 1];
        for (int cnt = price.length - 2; cnt >= 0; cnt--) {
            if (price[cnt] > max_sell)
                max_sell = price[cnt];
            profit[cnt] = Math.max(profit[cnt + 1], max_sell - price[cnt]);
        }
        System.out.println(Arrays.toString(profit));
        int min_buy = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] < min_buy)
                min_buy = price[i];
            profit[i] = Math.max(profit[i - 1], profit[i] + price[i] - min_buy);
        }
        System.out.println(Arrays.toString(profit));
    }

    private static void bestTimetoSellStock2(int[] input) {
        int maxProfit = 0;
        for (int cnt = 1; cnt < input.length; cnt++) {
            if (input[cnt] > input[cnt - 1])
                maxProfit += input[cnt] - input[cnt - 1];
        }
        System.out.println(maxProfit);
    }

    private static void bestTimetoSellStockI(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
            System.out.println(maxCur + " " + maxSoFar + " " + prices[i]);
        }
        System.out.println("max profit =>" + maxSoFar);

    }

    private static void bestTimetoSellStockII(int[] input) {
        int buy = 0, sell = 0;
        int maxprofit = 0;
        int transactions = 0;

        for (int cnt = 0; cnt < input.length; cnt++) {
            if (buy == 0) {
                buy = input[cnt];
            }
            inner: for (int icnt = cnt + 1; icnt < input.length; icnt++) {
                if (sell == 0 || sell < input[icnt])
                    sell = input[icnt];
                if (sell > buy)
                    break inner;
            }
            if (sell - buy > 0) {
                maxprofit += sell - buy;
                transactions++;
            }

            sell = 0;
            buy = 0;
        }
        System.out.println("Max profit => " + maxprofit + " with transactions => " + transactions);
    }

    private static void bestTimetoSellStock(int[] input) {
        int maxprofit = 0;
        int buy = input[0];
        for (int cnt = 1; cnt < input.length; cnt++) {
            maxprofit = Math.max(maxprofit, input[cnt] - buy);
            if (input[cnt] < buy) {
                buy = input[cnt];
            }
        }
        System.out.println("Max profit => " + maxprofit);
    }
}
