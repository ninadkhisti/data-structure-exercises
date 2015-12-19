package com.sample.linkedlist;

/**
 * Swap Nodes in Pair
 */
public class SwapNodesinPair {

    public static void main(String[] args) {
        ListNode j6 = new ListNode(19);
        ListNode j5 = new ListNode(15, j6);
        ListNode j4 = new ListNode(12, j5);
        ListNode j3 = new ListNode(9, j4);
        ListNode j2 = new ListNode(6, j3);
        ListNode j1 = new ListNode(5, j2);

        swapNodesInPair(j1);
    }

    private static void swapNodesInPair(ListNode j1) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (j1 != null && j1.next != null) {
            ListNode a = j1.next;
            ListNode b = j1.next.next;
            current.next = a;
            a.next = j1;
            j1.next = b;

            current = current.next;
            j1 = j1.next;

        }
        result.print();
    }
}
