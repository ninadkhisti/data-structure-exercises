package com.sample.linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are
stored in reverse order and each of their nodes contains a single digit. Add the two 
numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode i3 = new ListNode(3);
        ListNode i2 = new ListNode(4, i3);
        ListNode i1 = new ListNode(2, i2);

        ListNode j3 = new ListNode(4);
        ListNode j2 = new ListNode(6, j3);
        ListNode j1 = new ListNode(5, j2);

        addTwoNumbers(i1, j1);

    }

    public static void addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();

        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.data : 0;
            int y = l2 != null ? l2.data : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            if (sum >= 10)
                sum = sum - 10;

            head.next = new ListNode(sum);
            head = head.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        result.print();

    }
}
