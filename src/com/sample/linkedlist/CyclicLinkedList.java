package com.sample.linkedlist;

/**
 * Given a linked list, determine if it has a cycle in it.
 */
public class CyclicLinkedList {

    public static void main(String[] args) {
        ListNode i8 = new ListNode(3);
        ListNode i7 = new ListNode(3, i8);
        ListNode i6 = new ListNode(3, i7);
        ListNode i5 = new ListNode(3, i6);
        ListNode i4 = new ListNode(3, i5);
        ListNode i3 = new ListNode(2, i4);
        ListNode i2 = new ListNode(1, i3);
        ListNode i1 = new ListNode(1, i2);
        i8.next = i1;
        detectCycle(i1);
    }

    private static void detectCycle(ListNode i1) {
        ListNode faster = i1;
        ListNode slower = i1;

        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (faster == slower) {
                System.out.println("LOOP");
                break;
            }
        }
    }
}
