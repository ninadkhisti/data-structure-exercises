package com.sample.dynamicprogramming;

/**
 * TODO: Describe purpose and behavior of EditDistance
 */
public class EditDistance {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int result = editdistance(s1, s2);
        System.out.println(result);
    }

    private static int editdistance(String s1, String s2) {
        if ((s1 == null || s1.isEmpty()) && (s2 == null || s2.isEmpty()))
            return 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
