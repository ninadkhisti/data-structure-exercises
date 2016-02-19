package com.sample.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of GenerateParentheses
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        int n = 14;
        generateParentheses(result, "", 0, 0, n);
        System.out.println(result.toString());
    }

    private static void generateParentheses(List<String> result, String paren, int start, int end, int n) {
        if (2 * n == paren.length()) {
            result.add(new String(paren));
            return;
        }
        if (start < n)
            generateParentheses(result, paren.concat("("), start + 1, end, n);
        if (end < start)
            generateParentheses(result, paren.concat(")"), start, end + 1, n);

    }
}
