package com.sample.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * TODO: Describe purpose and behavior of SortNearlySortedArray
 */
public class SortNearlySortedArray {

    public static void main(String[] args) {
        int k = 3;
        int[] array = { 2, 6, 3, 12, 56, 8 };
        int[] result = sortNearlySorted(array, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortNearlySorted(int[] array, int k) {
        if (array == null || array.length == 0)
            return null;

        int[] result = new int[array.length];
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1);

        for (int cnt = 0; cnt < array.length; cnt++) {
            if (cnt > k) {
                int min = pq.peek();
                result[index++] = min;
                pq.remove(min);
            }
            pq.offer(array[cnt]);
        }
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }
}
