package com.sample;

/**
 * Substring
 */
public class Substring {

    public static void main(String[] args) {
        String haystack = "ninad";
        String needle = "d";

        int index = subString1(haystack, needle);
        System.out.println(index);
    }

    private static int subString1(String haystack, String needle) {

        for (int ocnt = 0;; ocnt++) {
            inner: for (int icnt = 0;; icnt++) {
                if (icnt == needle.length())
                    return ocnt;
                if (ocnt + icnt > haystack.length())
                    return -1;
                if (haystack.charAt(ocnt + icnt) != needle.charAt(icnt))
                    break inner;

            }
        }
    }
}
