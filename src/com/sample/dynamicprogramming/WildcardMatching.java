package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of WildcardMatching
 */
public class WildcardMatching {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean matches = wildcardmatch(s, p);
        System.out.println(matches);
        regularexpression();
    }

    private static boolean wildcardmatch(String s, String p) {
        if (p == null || p.length() == 0)
            return s == null || s.length() == 0;

        int r = s.length();
        int c = p.length();
        boolean[][] result = new boolean[r + 1][c + 1];
        result[0][0] = true;

        for (int cnt = 1; cnt <= c; cnt++) {
            if (p.charAt(cnt - 1) == '*') {
                result[0][cnt] = result[0][cnt - 1];
            }
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        result[i][j] = result[i - 1][j - 1];
                    }
                } else {
                    result[i][j] = result[i - 1][j] || result[i][j - 1] || result[i - 1][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result[r][c];
    }

    private static boolean regularexpression() {
        String s = "aab";
        String p = "c*a*b";

        if (p == null || p.length() == 0)
            return s == null || s.length() == 0;

        int r = s.length();
        int c = p.length();
        boolean[][] result = new boolean[r + 1][c + 1];
        result[0][0] = true;

        for (int cnt = 2; cnt <= c; cnt++) {
            if (p.charAt(cnt - 1) == '*') {
                result[0][cnt] = result[0][cnt - 2];
            }
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 2; j <= c; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        result[i][j] = result[i - 1][j - 1];
                    }
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        result[i][j] = result[i][j - 2];
                    } else {
                        result[i][j] = result[i - 1][j] || result[i][j - 1] || result[i][j - 2];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result[r][c];
    }
}
