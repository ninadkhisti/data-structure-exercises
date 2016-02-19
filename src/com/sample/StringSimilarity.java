package com.sample;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of StringSimilarity
 */
public class StringSimilarity {

    public static void main(String[] args) {

        String[] input = { "abcabncabc" };
        int[] result = stringSimilarity(input);
        System.out.println(Arrays.toString(result));

    }

    static int[] stringSimilarity(String[] inputs) {
        if (inputs == null || inputs.length == 0)
            return null;

        int[] result = new int[inputs.length];
        int index = 0;
        for (String input : inputs) {
            int similarity = input.length();
            if (similarity > 0) {
                for (int cnt = 1; cnt < input.length(); cnt++) {
                    if (input.charAt(cnt) == input.charAt(0)) {
                        similarity++;
                        int start = 1;
                        forloop: for (int icnt = cnt + 1; icnt < input.length(); icnt++) {
                            if (input.charAt(icnt) == input.charAt(start++))
                                similarity++;
                            else
                                break forloop;
                        }
                    }
                }
            }
            result[index++] = similarity;
        }
        return result;
    }
}
