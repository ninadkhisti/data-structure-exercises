package com.sample.dynamicprogramming;

/**
 * TODO: Describe purpose and behavior of WildcardMatching
 */
public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println(wildcardmatch("aa", "a"));
        System.out.println(wildcardmatch("aa", "aa"));
        System.out.println(wildcardmatch("aaa", "aa"));
        System.out.println(wildcardmatch("aa", "*"));
        System.out.println(wildcardmatch("aa", "a*"));
        System.out.println(wildcardmatch("ab", "?*"));
        System.out.println(wildcardmatch("aab", "c*a*b"));

        System.out.println(regularexpression("aa", "a"));
        System.out.println(regularexpression("aa", "aa"));
        System.out.println(regularexpression("aaa", "aa"));
        System.out.println(regularexpression("aa", "a*"));
        System.out.println(regularexpression("aa", ".*"));
        System.out.println(regularexpression("ab", ".*"));
        System.out.println(regularexpression("aab", "c*a*b"));

        System.out.println(regularexpressionEnhanced("abcd", "d*"));

        //System.out.println(regularexpressionEnhanced("aaab", "a+b"));
    }

    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * '+' Matches one or more of the preceding element.
     * @return true/false
     */
    private static boolean regularexpressionEnhanced(String s, String p) {
        if (p == null || p.isEmpty()) {
            return s == null || s.isEmpty();
        }
        int r = s.length();
        int c = p.length();
        boolean[][] dp = new boolean[r + 1][c + 1];
        dp[0][0] = true;
        for (int j = 1; j <= c; j++) {
            if (j > 1 && p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                char schar = s.charAt(i - 1);
                char pchar = p.charAt(j - 1);
                if (pchar != '*' && pchar != '+') {
                    if (schar == pchar || pchar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (pchar == '*') { // it is *
                    if (j > 1 && schar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2]; // match 0 chars
                    } else {
                        if (j > 1) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];//match 0 or more
                        }
                    }
                } else if (pchar == '+') {
                    if (j > 1 && schar == p.charAt(j - 2)) { //match
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // matched 1 or more
                    }
                }
            }
        }

        return dp[r][c];
    }

    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element. 
     * @return true/false
     */
    private static boolean regularexpression(String s, String p) {
        if (p == null || p.isEmpty()) {
            return s == null || s.isEmpty();
        }
        int r = s.length();
        int c = p.length();
        boolean[][] dp = new boolean[r + 1][c + 1];
        dp[0][0] = true;

        for (int j = 1; j <= c; j++) {
            if (p.charAt(j - 1) == '*' && j > 1) {
                dp[0][j] = dp[0][j - 2]; //throws an exception for 1st char* 
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                char schar = s.charAt(i - 1);
                char pchar = p.charAt(j - 1);

                if (pchar != '*') {
                    if (schar == pchar || pchar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { //it is *
                    if (j > 1 && schar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        if (j > 1) {
                            dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                        }
                    }
                }
            }
        }

        return dp[r][c];
    }

    /**
     *  * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * @return true/false
     */
    private static boolean wildcardmatch(String s, String p) {
        if (p == null || p.isEmpty())
            return s == null || s.isEmpty();

        int r = s.length();
        int c = p.length();
        boolean[][] dp = new boolean[r + 1][c + 1];
        dp[0][0] = true;

        for (int i = 1; i <= c; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                char schar = s.charAt(i - 1);
                char pchar = p.charAt(j - 1);
                if (pchar != '*') {
                    if (schar == pchar || pchar == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else { // it's * now
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }

        return dp[r][c];
    }

}
