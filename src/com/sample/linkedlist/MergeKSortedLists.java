package com.sample.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TODO: Describe purpose and behavior of MergeKSortedLists
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists merge = new MergeKSortedLists();
        ListNode n = new ListNode(1);
        ListNode[] nodes = { n };
        merge.mergeKLists(nodes);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null)
                pq.offer(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            p.next = node;
            p = p.next;

            if (node.next != null) {
                pq.offer(node.next);
            }

        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
