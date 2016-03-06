package com.sample.string;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of MinimumWindowSubstring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minwindowSubstring(s, t));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() <= 1)
            return 0;

        Map<Character, Integer> cmap = new HashMap<>();
        int left = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cmap.size() <= 2) {
                cmap.put(s.charAt(i), i);
            } else {
                int leftmost = s.length();
                for (Integer value : cmap.values()) {
                    leftmost = Math.min(leftmost, value);
                }
                Character key = s.charAt(leftmost);
                cmap.remove(key);
                left = leftmost + 1;
            }
            maxlength = Math.max(maxlength, i - left);
        }
        return maxlength;

    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, i - map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);

        }
        return max;
    }

    private static String minwindowSubstring(String s, String t) {
        if (t == null || t.length() == 0 || s.length() < t.length())
            return null;

        int minLen = Integer.MAX_VALUE, minLeft = Integer.MAX_VALUE, right = 0, left = 0;
        int count = 0;
        Map<Character, Integer> cmap = new HashMap<>();
        for (int cnt = 0; cnt < t.length(); cnt++) {
            if (cmap.containsKey(t.charAt(cnt))) {
                cmap.put(t.charAt(cnt), cmap.get(t.charAt(cnt)) + 1);
            } else {
                cmap.put(t.charAt(cnt), 1);
            }
        }
        while (right < s.length()) {
            if (cmap.containsKey(s.charAt(right))) {
                cmap.put(s.charAt(right), cmap.get(s.charAt(right)) - 1);
                if (cmap.get(s.charAt(right)) >= 0)
                    count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                if (cmap.containsKey(s.charAt(left))) {
                    cmap.put(s.charAt(left), cmap.get(s.charAt(left)) + 1);
                    if (cmap.get(s.charAt(left)) > 0)
                        count--;
                }
                left++;
            }
            right++;
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}
