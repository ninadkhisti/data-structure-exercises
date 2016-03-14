package com.sample.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * TODO: Describe purpose and behavior of LongestValidParenthesis
 */
public class ParenthesisStuff {

    public static void main(String[] args) {
        String input = "(()())";
        int result = longestvalidparenthesis(input);
        System.out.println(result);
        System.out.println(validParenthesiss("()()()()()(()(()()()()))"));
        System.out.println(removeInvalidParenthesis("(a)())()"));
        System.out.println(removeInvalidParenthesis("()())()"));
        System.out.println(removeInvalidParenthesis(")("));
        System.out.println(removeInvalidParenthesisII("()())()"));
    }

    private static int longestvalidparenthesis(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = Integer.MIN_VALUE;
        int baseLastPos = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    int lastPos = baseLastPos;
                    if (!stack.empty())
                        lastPos = stack.peek();
                    result = Math.max(result, i - lastPos);
                } else
                    baseLastPos = i;
            }
        }

        return result;
    }

    private static boolean validParenthesiss(String input) {
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                cnt++;
            } else if (input.charAt(i) == ')') {
                if (cnt <= 0) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }

    private static List<String> removeInvalidParenthesisII(String input) {
        if (input == null || input.isEmpty())
            return Collections.emptyList();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(input);
        visited.add(input);
        boolean found = false;
        while (!queue.isEmpty()) {
            String a = queue.remove();

            if (validParenthesiss(a)) {
                result.add(a);
                found = true;
            }

            if (found)
                continue;

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != '(' && a.charAt(i) != ')')
                    continue;
                String prefix = a.substring(0, i);
                String postfix = a.substring(i + 1);
                String newinput = prefix + postfix;
                if (!visited.contains(newinput)) {
                    visited.add(newinput); //visited
                    queue.add(newinput);
                }
            }

        }
        return result;
    }

    private static String removeInvalidParenthesis(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        Stack<Item> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')' && (stack.isEmpty() || stack.peek().ch != '(')) {
                Item item = new Item();
                item.ch = ')';
                item.index = i;
                stack.push(item);
            }

            if (input.charAt(i) == '(') {
                Item item = new Item();
                item.ch = '(';
                item.index = i;
                stack.push(item);
            }

            if (input.charAt(i) == ')' && !stack.isEmpty() && stack.peek().ch == '(') {
                stack.pop();
            }

        }
        System.out.println(stack.toString());
        StringBuilder sb = new StringBuilder(input);
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop().index);
        }
        return sb.toString();
    }

    static class Item {
        char ch;
        int index;

        public String toString() {
            return "ch =" + ch + " i =" + this.index;
        }
    }

}
