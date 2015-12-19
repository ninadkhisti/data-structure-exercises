package com.sample.stack;

import java.util.EmptyStackException;

/**
 * Stack implementation
 */
public class Stack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> stackItem = new StackNode<T>(item);
        stackItem.next = top;
        top = stackItem;
    }
    
    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }

}
