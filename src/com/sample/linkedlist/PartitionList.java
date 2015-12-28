package com.sample.linkedlist;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode i6 = new ListNode(2);
        ListNode i5 = new ListNode(5, i6);
        ListNode i4 = new ListNode(2, i5);
        ListNode i3 = new ListNode(3, i4);
        ListNode i2 = new ListNode(4, i3);
        ListNode i1 = new ListNode(1, i2);

        ListNode node = partitionList(i1);
        node.print();
    }

    private static ListNode partitionList(ListNode node) {
        ListNode head = node;
        ListNode tail = node;
        int x = 3;

        while (node != null) {
            ListNode next = node.next;
            if (node.data <= x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }
}
