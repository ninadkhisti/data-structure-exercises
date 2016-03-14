package com.sample.design;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of LRUCache
 */
public class LRUCache {

    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new ListNode();
        tail = new ListNode();

        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;//cache miss
        }
        moveToHead(node);
        return node.data;
    }

    public void set(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) { //add
            ListNode newnode = new ListNode();
            newnode.key = key;
            newnode.data = value;

            cache.put(key, newnode);
            this.addNode(newnode);
            size++;
            if (size > capacity) {
                this.size--;
                ListNode tailender = this.popTail();
                cache.remove(tailender.key);
                this.addNode(newnode);
            }
        } else { //update
            node.data = value;
            this.moveToHead(node);
        }

    }

    class ListNode {
        int key;
        int data;
        ListNode previous;
        ListNode next;
    }

    /**
     * add to hear
     */
    private void addNode(ListNode node) {
        ListNode next = head.next;
        head.next = node;
        next.previous = node;

        node.previous = head;
        node.next = next;
    }

    private void deleteNode(ListNode node) {
        ListNode prev = node.previous;
        ListNode next = node.next;

        prev.next = next;
        next.previous = prev;

    }

    private void moveToHead(ListNode node) {
        this.deleteNode(node);
        this.addNode(node);
    }

    private ListNode popTail() {
        ListNode tailender = tail.previous;
        this.deleteNode(tailender);
        return tailender;
    }

}
