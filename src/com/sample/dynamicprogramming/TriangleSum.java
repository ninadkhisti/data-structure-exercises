package com.sample.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TriangleSum
 */
public class TriangleSum {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        l0.add(2);
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(4);
        List<Integer> l2 = new ArrayList<>();
        l2.add(6);
        l2.add(5);
        l2.add(7);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(1);
        l3.add(8);
        l3.add(3);
        triangle.add(l0);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        System.out.println(Arrays.toString(A));
        return A[0];
    }

}
