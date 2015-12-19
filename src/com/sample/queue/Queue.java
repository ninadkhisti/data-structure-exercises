package com.sample.queue;

import java.util.EmptyStackException;

/**
 * Queue implementation
 * 
 * F -> 1 -> 2 -> 3 -> L (add)
 */
public class Queue<T> {

    private static class QueueNode<T> {
        public T data;
        public QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> node = new QueueNode<T>(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null)
            throw new EmptyStackException();
        QueueNode<T> node = first;
        first = first.next;
        if (first == null)
            last = null;
        return node.data;
    }

    public T peek() {
        if (first == null)
            throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
