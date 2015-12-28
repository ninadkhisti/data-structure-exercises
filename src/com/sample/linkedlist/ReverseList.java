package com.sample.linkedlist;

/**
 * Reverse a singly linked list.
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(8);
        ListNode i7 = new ListNode(7, i8);
        ListNode i6 = new ListNode(6, i7);
        ListNode i5 = new ListNode(5, i6);
        ListNode i4 = new ListNode(4, i5);
        ListNode i3 = new ListNode(3, i4);
        ListNode i2 = new ListNode(2, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode node = reverseList(i1);
        node.print();
    }

    private static ListNode reverseList(ListNode node) {
        ListNode head = new ListNode(0);
        ListNode q = node;

        while (q != null) {
            ListNode next = q.next;
            //set next to head
            q.next = head;
            //reset head itself
            head = q;
            //copy next back to q
            q = next;
        }
        return head;
    }

    private static ListNode reverseListII(ListNode node) {
        int m = 2;
        int n = 5;
        ListNode q = node;
        int cnt = 0;
        while (q != null) {
            //dummy-> 1 -> 2 -> 3 -> 4 -> 5
            ListNode p = q.next;
            if (cnt >= m && cnt < n) {

            }
            q = p;
            cnt++;
        }
        return null;
    }
}
