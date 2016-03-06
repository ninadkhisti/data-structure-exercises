package com.sample.linkedlist;

/**
 * TODO: Describe purpose and behavior of Flatten2DLinkedList
 */
public class Flatten2DLinkedList {

    public void flattenLinkedList(ListNode head) {
        if (head == null)
            return;

        ListNode tail = head;
        while (tail != null) {
            tail = tail.next;
        }

        ListNode p = head;
        while (p != null) {
            if (p.child != null) {
                ListNode childNode = p.child;

                tail.next = childNode;
                while (tail.next != null) {
                    tail = tail.next;
                }
                p.child = null;
            }
            p = p.next;
        }

    }

    class ListNode {
        int data;
        ListNode next;
        ListNode child;
    }
}
