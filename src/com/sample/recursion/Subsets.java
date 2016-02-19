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
        printSubsetsIII(input);
        printPermutations(input);
    }

    private static void printPermutations(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(input[0]);
        result.add(one);

        for (int i = 1; i < input.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> ptmp : result) {
                    List<Integer> ntmp = new ArrayList<>(ptmp);
                    ntmp.add(j, input[i]);
                    tmp.add(ntmp);
                }
            }
            result = tmp;
        }
        System.out.println(result.toString());
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

    private static void printSubsetsIII(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        addSubsets(input, current, 0, result);
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        System.out.println(result.toString());
    }

    private static void addSubsets(int[] input, List<Integer> current, int start, List<List<Integer>> result) {
        if (start >= input.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        int i = start;
        while (i < input.length) {
            current.add(input[i]);
            addSubsets(input, new ArrayList<>(current), i + 1, result);
            current.remove(current.size() - 1);
            i++;
        }

    }

    private static void printSubsetsII(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        if (input == null || input.length == 0)
            System.out.println(result.toString());

        Arrays.sort(input);

        for (int cnt = 0; cnt < input.length; cnt++) {
            List<List<Integer>> tmps = new ArrayList<List<Integer>>();
            for (List<Integer> subset : result) {
                List<Integer> tmp = new ArrayList<>(subset);
                if (cnt > 0 && input[cnt] == input[cnt - 1]) {
                    if (tmp.size() > 0 && tmp.get(tmp.size() - 1) == input[cnt]) {
                        tmp.add(input[cnt]);
                    } else {
                        continue;
                    }
                } else {
                    tmp.add(input[cnt]);
                }
                tmps.add(tmp);
            }
            result.addAll(tmps);
        }
        System.out.println(result.toString());
    }
}
