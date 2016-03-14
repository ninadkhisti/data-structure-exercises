package com.sample.string;

/**
 * TODO: Describe purpose and behavior of LongestPalindromicSubstring
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "aabbbbkkvmdflvlkf";
        System.out.println(longestPalindromicSubstring(input));
    }

    static int maxlength = Integer.MIN_VALUE;
    static int left;

    private static String longestPalindromicSubstring(String input) {
        if (input == null || input.isEmpty())
            return null;

        for (int cnt = 0; cnt < input.length(); cnt++) {
            palindromicString(cnt, cnt, input);
            palindromicString(cnt, cnt + 1, input);
        }

        return input.substring(left, left + maxlength);
    }

    private static void palindromicString(int i, int j, String input) {
        while (i >= 0 && j <= input.length() - 1 && input.charAt(i) == input.charAt(j)) {
            if (j - i + 1 > maxlength) {
                maxlength = j - i + 1;
                left = i;
            }
            i--;
            j++;
        }
    }
}
