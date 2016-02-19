package com.sample.math;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of PerfectSquares
 */
public class PerfectSquares {

    public static void main(String[] args) {

        int n = 92;
        int result = perfectSquares(n);
        int r1 = perfectSquareDP(n);
        System.out.println(result);
        System.out.println(r1);
    }

    private static int perfectSquares(int n) {
        if (perfectSquare(n))
            return 1;

        //4^a(8*b+7) Legendre's Three Square problem
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7)
            return 4;
        int s = (int) Math.sqrt(n);
        for (int cnt = 1; cnt <= s; cnt++) {
            if (perfectSquare(n - (cnt * cnt))) {
                return 2;
            }
        }
        return 3;
    }

    private static int perfectSquareDP(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        //result[2]= result[2-1*1] + 1 = 2

        for (int cnt = 2; cnt <= n; cnt++) {
            int min = Integer.MAX_VALUE;
            for (int icnt = 1; icnt <= (int) Math.sqrt(cnt); icnt++) {
                min = Math.min(min, result[cnt - (icnt * icnt)] + 1);
            }
            result[cnt] = min;
        }
        System.out.println(Arrays.toString(result));
        return result[n];
    }

    private static boolean perfectSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }
}
