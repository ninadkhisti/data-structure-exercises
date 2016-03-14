package com.sample.design;

import com.sample.stack.Stack;

/**
 * TODO: Describe purpose and behavior of MinStack
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (popped == min.peek())
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(0);
        minstack.push(1);
        minstack.push(0);
        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.getMin());
    }
}
