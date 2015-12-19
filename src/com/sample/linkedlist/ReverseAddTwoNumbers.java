package com.sample.linkedlist;

/**
 *  You are given two linked lists representing two non-negative numbers. The digits are
stored in reverse order and each of their nodes contains a single digit. Add the two 
numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class ReverseAddTwoNumbers {

    public static void main(String[] args) {
        ListNode i3 = new ListNode(3);
        ListNode i2 = new ListNode(4, i3);
        ListNode i1 = new ListNode(9, i2);

        ListNode j3 = new ListNode(4);
        ListNode j2 = new ListNode(6, j3);
        ListNode j1 = new ListNode(5, j2);

        addTwoNumbers(i1, j1);

    }

    private static void addTwoNumbers(ListNode i1, ListNode j1) {
        PartialSum sum = addListHelper(i1, j1);
        if (sum.carry == 0) {
            sum.sum.print();
        } else {
            ListNode result = insertBefore(sum.sum, sum.carry);
            result.print();
        }
    }

    private static PartialSum addListHelper(ListNode i1, ListNode j1) {
        if (i1 == null && j1 == null) {
            return new PartialSum();
        }
        PartialSum sum = addListHelper(i1.next, j1.next);
        int val = sum.carry + i1.data + j1.data;
        ListNode result = insertBefore(sum.sum, val % 10);
        sum.sum = result;
        sum.carry = val / 10;
        return sum;
    }

    private static ListNode insertBefore(ListNode sum, int i) {
        ListNode node = new ListNode(i);
        if (sum != null) {
            node.next = sum;
        }
        return node;
    }

}

class PartialSum {
    public ListNode sum = null;
    public int carry = 0;
}
