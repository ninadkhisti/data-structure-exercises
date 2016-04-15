package com.sample;

/**
 * TODO: Describe purpose and behavior of MedianOfSortedArrays
 */
public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] a1 = { 1, 12, 15, 26, 38 };
        int[] a2 = { 2, 13, 17, 30, 45 };
        System.out.println(arraysMedian(a1, a2));
        System.out.println(findMedianSortedArrays(a1, a2));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays(B, A);

        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                l = midA + 1;
            else
                r = midA;
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1] 

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by 
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }

    private static int arraysMedian(int[] a1, int[] a2) {

        if (a1.length != a2.length)
            return -1;
        if (a1.length == 0)
            return -1;
        if (a1.length == 1 && a2.length == 1)
            return (a1[0] + a2[0]) / 2;
        if (a1.length == 2 && a2.length == 2)
            return (Math.max(a1[0], a2[0]) + Math.min(a1[1], a2[1])) / 2;

        int m1 = median(a1);
        int m2 = median(a2);

        if (m1 > m2) {
            int a[] = getLeftArray(a1);
            int b[] = getRightArray(a2);
            return arraysMedian(a, b);
        } else if (m1 < m2) {
            int a[] = getLeftArray(a2);
            int b[] = getRightArray(a1);
            return arraysMedian(a, b);
        } else { //m1 == m2
            return m1;
        }
    }

    private static int[] getRightArray(int[] a1) {
        int n = a1.length;
        if (n % 2 == 0) {
            int[] a = new int[n / 2];
            int index = 0;
            for (int i = n / 2; i < n; i++) {
                a[index++] = a1[i];
            }
            return a;
        } else {
            int[] a = new int[n / 2 + 1];
            int index = 0;
            for (int i = n / 2; i < n; i++) {
                a[index++] = a1[i];
            }
            return a;
        }
    }

    private static int[] getLeftArray(int[] a1) {
        int n = a1.length;
        if (n % 2 == 0) {
            int[] a = new int[n / 2];
            for (int i = 0; i < (n / 2); i++) {
                a[i] = a1[i];
            }
            return a;
        } else {
            int[] a = new int[n / 2 + 1];
            for (int i = 0; i < n / 2 + 1; i++) {
                a[i] = a1[i];
            }
            return a;
        }
    }

    private static int median(int[] a1) {
        int n = a1.length;
        if (n % 2 == 0)
            return (a1[n / 2] + a1[n / 2 - 1]) / 2;
        return a1[n / 2];
    }
}
