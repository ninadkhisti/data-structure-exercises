package com.sample.string;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of PalindromePermutation
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String input = "as";

        boolean result = palindromePermutaion(input);
        System.out.println(result);
    }

    private static boolean palindromePermutaion(String input) {
        Set<Character> set = new HashSet<>();

        for (int cnt = 0; cnt < input.length(); cnt++) {
            if (!set.contains(input.charAt(cnt)))
                set.add(input.charAt(cnt));
            else
                set.remove(input.charAt(cnt));
        }

        return set.isEmpty() || set.size() == 1;
    }
}
