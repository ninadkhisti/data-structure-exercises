package com.sample.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * TODO: Describe purpose and behavior of FindMedianDataStream
 */
public class FindMedianDataStream {

    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxheap = new PriorityQueue<>(1000, Collections.reverseOrder());

    public static void main(String[] args) {
        FindMedianDataStream median = new FindMedianDataStream();
        median.add(2);
        System.out.println(median.findMedian());
        median.add(3);
        System.out.println(median.findMedian());

        /*median.add(10);
        median.add(1);
        median.add(20);
        median.add(4);
        median.add(9);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
         median.add(2);
        median.add(250);
        median.add(0);
        median.add(25);
        median.add(40);
        median.add(20);*/

        System.out.println(median.findMedian());
    }

    public void add(int i) {
        maxheap.add(i);
        minheap.add(maxheap.remove());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.remove());
        }
    }

    public double findMedian() {
        System.out.println(maxheap.toString());
        System.out.println(minheap.toString());
        if (minheap.size() == maxheap.size())
            return (double) (minheap.peek() + maxheap.peek()) / 2;
        return maxheap.peek();
    }
}
