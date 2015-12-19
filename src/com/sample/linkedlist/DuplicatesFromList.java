package com.sample.linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */
public class DuplicatesFromList {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(3);
        ListNode i7 = new ListNode(3, i8);
        ListNode i6 = new ListNode(3, i7);
        ListNode i5 = new ListNode(3, i6);
        ListNode i4 = new ListNode(3, i5);
        ListNode i3 = new ListNode(2, i4);
        ListNode i2 = new ListNode(1, i3);
        ListNode i1 = new ListNode(1, i2);
        removeDuplicates(i1);
        removeDuplicatesII(i1);
    }

    private static void removeDuplicates(ListNode i1) {
        ListNode result = new ListNode();
        int previous = 0;
        ListNode current = result;

        while (i1 != null) {
            if (previous != i1.data) {
                current.next = new ListNode(i1.data);
                current = current.next;
            }
            previous = i1.data;
            i1 = i1.next;
        }
        result.print();
    }

    private static void removeDuplicatesII(ListNode i1) {
        ListNode result = new ListNode();
        result.next = i1;
        ListNode pre = result;
        ListNode cur = i1;

        while (cur != null) {
            while (cur.next != null && cur.data == cur.next.data) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        result.print();
    }
}
