package com.sample.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeList {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(8);
        ListNode i7 = new ListNode(7, i8);
        ListNode i6 = new ListNode(6, i7);
        ListNode i5 = new ListNode(5, i6);
        ListNode i4 = new ListNode(4, i5);
        ListNode i3 = new ListNode(3, i4);
        ListNode i2 = new ListNode(2, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode node = removeNthNode(i1);
        node.print();
    }

    private static ListNode removeNthNode(ListNode node) {
        ListNode p = node;
        ListNode q = node;
        int n = 2;
        int cnt = 0;
        while (p != null && cnt < n + 1) {
            p = p.next;
            cnt++;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return node;
    }
}
