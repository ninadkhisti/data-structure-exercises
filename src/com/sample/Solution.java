package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of Solution
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.removeInvalidParentheses("x(");
        System.out.println(result.toString());
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.isEmpty())
            return Collections.emptyList();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean resultFound = false;
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String a = queue.remove();
            if (isValid(a)) {
                resultFound = true;
                result.add(a);
            }
            if (resultFound)
                continue;

            for (int cnt = 0; cnt < a.length(); cnt++) {
                String prefix = a.substring(0, cnt);
                String postfix = a.substring(cnt + 1);

                String newString = prefix.concat(postfix);
                if (!visited.contains(newString)) {
                    queue.add(newString);
                    visited.add(newString);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')') {
                if (count <= 0)
                    return false;
                count--;
            }

        }
        return count == 0;
    }
}