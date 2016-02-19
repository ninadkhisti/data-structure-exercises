package com.sample.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of CombinationSum
 */
public class CombinationSum {

    class Combination {
        int sum = 0;
        List<Integer> combination = new ArrayList<Integer>();

        public String toString() {
            return combination.toString();
        }
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 7, 6, 1, 5 };
        int target = 8;
        //int[] input = { 1, 2, 3 };
        //int target = 4;

        List<List<Integer>> result = new ArrayList<>();
        chelper(input, result, new ArrayList<Integer>(), target, 0);
        System.out.println(result.toString());

        List<List<Integer>> r1 = new ArrayList<>();
        Arrays.sort(input);
        chelperII(input, r1, new ArrayList<Integer>(), target, 0);
        System.out.println(r1);
        combinations();
    }

    private static void chelper(int[] input, List<List<Integer>> result, List<Integer> combi, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combi));
            return;
        }
        for (int cnt = start; cnt < input.length; cnt++) {
            if (input[cnt] <= target) {
                combi.add(input[cnt]);
                //chelper(input, result, combi, target - input[cnt], cnt);
                chelper(input, result, combi, target - input[cnt], cnt + 1);
                combi.remove(combi.size() - 1);
            }
        }
    }

    private static void chelperII(int[] input, List<List<Integer>> result, List<Integer> combi, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combi));
            return;
        }
        for (int cnt = start; cnt < input.length; cnt++) {
            if (cnt > start && input[cnt] == input[cnt - 1])
                continue;
            if (input[cnt] <= target) {
                combi.add(input[cnt]);
                chelperII(input, result, combi, target - input[cnt], cnt + 1);
                combi.remove(combi.size() - 1);
            }
        }
    }

    private static void combinations() {
        int[] input = { 2, 3, 6, 7 };
        int k = 7;
        int[] input1 = { 10, 1, 2, 7, 6, 1, 5 };
        Arrays.sort(input1);
        int k1 = 8;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        //backtrackCombinations(input, k, 0, current, result);
        backtrackCombinationsII(input1, k1, 0, current, result);
        System.out.println(result.toString());
    }

    private static void backtrackCombinations(int[] input, int currk, int start, List<Integer> current,
            List<List<Integer>> result) {

        if (currk == 0 && current.size() > 0) {
            result.add(current);
            return;
        }
        if (start >= input.length) {
            return;
        }
        for (int cnt = start; cnt < input.length; cnt++) {
            int target = currk - input[cnt];
            if (target >= 0) {
                current.add(input[cnt]);
                backtrackCombinations(input, target, cnt, new ArrayList<>(current), result);
                //backtrackCombinations(input, target, start + 1, new ArrayList<>(current), result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static void backtrackCombinationsII(int[] input, int currk, int start, List<Integer> current,
            List<List<Integer>> result) {

        if (currk == 0 && current.size() > 0) {
            result.add(current);
            return;
        }
        if (start >= input.length) {
            return;
        }
        for (int cnt = start; cnt < input.length; cnt++) {
            int target = currk - input[cnt];
            if (target >= 0) {
                current.add(input[cnt]);
                backtrackCombinationsII(input, target, cnt + 1, new ArrayList<>(current), result);
                current.remove(current.size() - 1);
            }
        }
    }

}