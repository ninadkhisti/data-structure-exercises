package com.sample.linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(6);
        ListNode i7 = new ListNode(6, i8);
        ListNode i6 = new ListNode(5, i7);
        ListNode i5 = new ListNode(4, i6);
        ListNode i4 = new ListNode(3, i5);
        ListNode i3 = new ListNode(6, i4);
        ListNode i2 = new ListNode(2, i3);
        ListNode i1 = new ListNode(1, i2);

        removeElements(i1);
    }

    private static void removeElements(ListNode i1) {
        ListNode result = new ListNode();
        ListNode cur = result;
        int value = 6;
        while (i1 != null) {
            if (i1.data == value) {
                i1 = i1.next;
                continue;
            }
            cur.next = new ListNode(i1.data);
            cur = cur.next;
            i1 = i1.next;
        }
        result.print();

    }
}
