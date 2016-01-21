package com.sample.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of Test
 */
public class Subsets {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        printSubsets(input);
    }

    private static void printSubsets(int[] input) {
        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for (int cnt = 0; cnt < input.length; cnt++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> subset : result) {
                List<Integer> a = new ArrayList<Integer>(subset);
                a.add(input[cnt]);
                tmp.add(a);
            }
            result.addAll(tmp);
        }
        System.out.println(result.toString());
    }
}
