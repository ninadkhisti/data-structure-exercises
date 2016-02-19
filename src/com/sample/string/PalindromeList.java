package com.sample.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindromic pair of a list of strings
Given a list of strings, find all the palindromic pairs of the string and output the concatenated palindrome.

e.g. [abc, cba], output is abccba, cbaabc.
e.g. [aabc, cb], output is cbaabc
 */
public class PalindromeList {

    public static void main(String[] args) {
        String[] input = { "aabc", "cb", "abc", "cba" };
        List<String> palindromes = palindromeStrings(input);
        System.out.println(palindromes.toString());
    }

    private static List<String> palindromeStrings(String[] input) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String a : input) {
            map.put(reverse(a), a);
        }
        for (String a : input) {
            for (int j = 0; j < a.length(); j++) {
                String prefix = a.substring(0, j);
                String plaindrome = a.substring(j);
                if (map.containsKey(prefix) && palindrome(plaindrome)) {
                    if (map.get(prefix).equals(a))
                        continue;
                    result.add(a.concat(reverse(prefix)));
                }
            }
            for (int j = a.length() - 1; j >= 0; j--) {
                String palindrome = a.substring(0, j);
                String postfix = a.substring(j);
                if (map.containsKey(postfix) && palindrome(palindrome)) {
                    if (map.get(postfix).equals(a))
                        continue;
                    result.add(reverse(postfix).concat(a));
                }
            }
        }

        return result;
    }

    private static boolean palindrome(String plaindrome) {
        char[] pchars = plaindrome.toCharArray();
        if (pchars.length == 0)
            return true;
        int l = 0;
        int r = pchars.length - 1;
        while (l < r) {
            if (pchars[l] != pchars[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

    private static String reverse(String a) {
        char[] array = a.toCharArray();
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        return new String(array);
    }
}
