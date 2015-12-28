package com.sample.linkedlist;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(8);
        ListNode i7 = new ListNode(7, i8);
        ListNode i6 = new ListNode(6, i7);
        ListNode i5 = new ListNode(5, i6);
        ListNode i4 = new ListNode(4, i5);
        ListNode i3 = new ListNode(3, i4);
        ListNode i2 = new ListNode(2, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode node = rotateList(i1);
        node.print();
    }

    private static ListNode rotateList(ListNode node) {
        int k = 5;
        ListNode p = node;
        ListNode q = node;
        ListNode rotate = null;
        int cnt = 0;
        while (p != null && cnt < k) {
            p = p.next;
            cnt++;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        rotate = q.next;
        q.next = null;

        ListNode head = new ListNode(0);
        head.next = rotate;
        cnt = 0;
        while (rotate != null && cnt < k - 1) {
            rotate = rotate.next;
            cnt++;
        }
        rotate.next = node;
        return head;
    }
}
