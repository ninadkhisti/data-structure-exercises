package com.sample.linkedlist;

/**
 * Merge two sorted lists
 */
public class MergeTwoLists {

    public static void main(String[] agrs) {
        ListNode i3 = new ListNode(7);
        ListNode i2 = new ListNode(2, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode j6 = new ListNode(19);
        ListNode j5 = new ListNode(15, j6);
        ListNode j4 = new ListNode(12, j5);
        ListNode j3 = new ListNode(9, j4);
        ListNode j2 = new ListNode(6, j3);
        ListNode j1 = new ListNode(5, j2);

        mergeTwoLists(i1, j1);
    }

    private static void mergeTwoLists(ListNode i1, ListNode j1) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (i1 != null && j1 != null) {
            if (i1.data < j1.data) {
                current.next = new ListNode(i1.data);
                current = current.next;
                i1 = i1.next;

            } else {
                current.next = new ListNode(j1.data);
                current = current.next;
                j1 = j1.next;
            }
        }
        if (i1 != null)
            current.next = i1;
        if (j1 != null)
            current.next = j1;
        result.print();
    }
}
