package com.sample.string;

import java.util.ArrayList;
import java.util.Collections;
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
        String[] input = { "aabc", "cb", "abc", "cba", "c" };
        //String[] input = { "c", " " };
        List<String> palindromes = palindromeStrings(input);
        List<List<Integer>> result = palindromePairs(input);
        //System.out.println(palindromes.toString());
        System.out.println(result.toString());
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> reverseMap = new HashMap<>();
        int index = 0;
        for (String a : words) {
            reverseMap.put(reverse(a), index++);
        }
        for (int i = 0; i < words.length; i++) { // null string as input
            String a = words[i];
            //prefixes
            for (int cnt = 0; cnt < a.length(); cnt++) {
                String prefix = a.substring(0, cnt);
                String palindrome = a.substring(cnt);

                if (reverseMap.containsKey(prefix) && palindrome(palindrome)) {
                    if (reverseMap.get(prefix).equals(i))
                        continue;
                    List<Integer> entry = new ArrayList<>();
                    entry.add(i);
                    entry.add(reverseMap.get(prefix));
                    result.add(entry);
                }
            }
            //postfixes
            for (int cnt = a.length() - 1; cnt >= 0; cnt--) {
                String palindrome = a.substring(0, cnt);
                String postfix = a.substring(cnt);

                if (reverseMap.containsKey(postfix) && palindrome(palindrome)) {
                    if (reverseMap.get(postfix).equals(i))
                        continue;
                    List<Integer> entry = new ArrayList<>();
                    entry.add(reverseMap.get(postfix));
                    entry.add(i);
                    result.add(entry);
                }
            }
        } //outer for
        return result;
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
        if (a == null || a.length() <= 1)
            return a;
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
