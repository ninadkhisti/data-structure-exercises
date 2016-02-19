package com.sample.array;

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
        bestTimetoSellStockCooldown(input);
    }

    private static void bestTimetoSellStockCooldown(int[] input) {
        int buy = input[0];
        int maxprofit = 0;
        boolean cooldown = false;
        for (int cnt = 1; cnt < input.length; cnt++) {
            if (cooldown) {
                cooldown = false;
                continue;
            }
            if (input[cnt] > buy && buy > 0) {
                maxprofit += input[cnt] - buy;
                cooldown = true;
                buy = 0;
            } else if (buy == 0 || input[cnt] < buy) {
                buy = input[cnt];
            }
        }
        System.out.println("Max profit with cooldown =>" + maxprofit);

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
