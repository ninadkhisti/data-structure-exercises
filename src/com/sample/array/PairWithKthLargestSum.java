package com.sample.array;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of PairWithKthLargestSum
 */
public class PairWithKthLargestSum {

    public static void main(String[] args) {
        int nums1[] = { 2, 3, 5, 8, 13 };
        int nums2[] = { 4, 8, 12, 16 };

        // 2 +4 =6
        // 3 +4 = 7
        // 4 +5 = 9
        // 2 + 8 =10
        System.err.println(findKthSmallestSum(nums1, nums2, 8));

    }

    public static int findKthSmallestSum(final int nums1[], final int nums2[], int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(10, new Comparator<Pair>() {
            public int compare(Pair pair1, Pair pair2) {
                //              return Integer.compare(nums1[pair1.i] + nums2[pair1.j], nums1[pair2.i] + nums2[pair2.j]); // smallest
                return Integer.compare(nums1[pair2.i] + nums2[pair2.j], nums1[pair1.i] + nums2[pair1.j]); // largest

            }
        });

        pq.add(new Pair(nums1.length - 1, nums2.length - 1));

        int count = 0;
        Set<Integer> sumsFound = new HashSet<Integer>();
        while (!pq.isEmpty() && count < k) {
            Pair pair = pq.poll();
            int currentSum = nums1[pair.i] + nums2[pair.j];
            if (!sumsFound.contains(currentSum)) {
                if (count == k - 1) {
                    return currentSum;
                }
                sumsFound.add(currentSum);
                count++;
            }

            if (pair.i - 1 >= 0) {
                pq.add(new Pair(pair.i - 1, pair.j));
            }
            if (pair.j - 1 >= 0) {
                pq.add(new Pair(pair.i, pair.j - 1));
            }

        }

        return -1;
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "[" + i + "," + j + "]";
        }
    }

}
