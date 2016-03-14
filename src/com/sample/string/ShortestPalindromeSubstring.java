package com.sample.string;

/**
 * TODO: Describe purpose and behavior of ShortestPalindromeSubstring
 */
public class ShortestPalindromeSubstring {

    public static void main(String[] args) {
        String input = "aacecaaa";
        System.out.println(shortestPalindrome(input));
    }

    private static String shortestPalindrome(String input) {
        if (input == null || input.isEmpty())
            return input;

        int i = 0, j = input.length() - 1, end = j;
        while (i < j) {
            if (input.charAt(i) == input.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }

        return new StringBuilder(input.substring(end + 1)).reverse().toString().concat(input);
    }
}
