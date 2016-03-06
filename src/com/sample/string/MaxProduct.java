package com.sample.string;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of MaxProduct
 */
public class MaxProduct {

    public static void main(String[] args) {
        String[] input = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(maxProduct(input));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int[] masks = new int[words.length];
        int index = 0;
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << word.charAt(i) - 'a');
            }
            masks[index++] = mask;
        }
        System.out.println(Arrays.toString(masks));
        //int max = Integer.MIN_VALUE; produces wrong result for -214
        int max = 0;
        for (int i = 0; i < masks.length - 1; i++) {
            for (int j = i + 1; j < masks.length; j++) {
                if ((masks[i] & masks[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
