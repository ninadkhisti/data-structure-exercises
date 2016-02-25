package com.sample.dynamicprogramming;

import java.util.Stack;

/**
 * TODO: Describe purpose and behavior of LongestValidParenthesis
 */
public class ParenthesisStuff {

    public static void main(String[] args) {
        String input = ")()())";
        int result = longestvalidparenthesis(input);
        System.out.println(result);
        System.out.println(validParenthesiss("()()()()()(()(()()()()))"));
        System.out.println(removeInvalidParenthesis("(a)())()"));
        System.out.println(removeInvalidParenthesis("()())()"));
        System.out.println(removeInvalidParenthesis(")("));
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
