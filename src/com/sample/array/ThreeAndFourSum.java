package com.sample.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 1. Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * 2. The solution set must not contain duplicate triplets.
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class ThreeAndFourSum {

    public static void main(String[] args) {

        Integer[] input = { -1, 0, 1, 2, -1, -4 };
        threeSum(input);
        threeSumII(input);

        Integer[] input1 = { 1, 0, -1, 0, -2, 2 };
        fourSum(input1);
        fourSumII(input1);
    }

    private static void fourSumII(Integer[] input) {
        Arrays.sort(input);
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            List<Integer> indexes = indexMap.get(input[cnt]);
            if (indexes == null) {
                indexes = new ArrayList<>();
                indexes.add(cnt);
                indexMap.put(input[cnt], indexes);
            } else {
                indexes.add(cnt);
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    int reminder = sum - (input[i] + input[j] + input[k]);
                    if (indexMap.containsKey(reminder)) {
                        List<Integer> indexes = indexMap.get(reminder);
                        for (Integer index : indexes) {
                            if (index > k) {
                                List<Integer> quartlet = new ArrayList<>();
                                quartlet.add(input[i]);
                                quartlet.add(input[j]);
                                quartlet.add(input[k]);
                                quartlet.add(reminder);
                                result.add(quartlet);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result.toString());
    }

    private static void fourSum(Integer[] input) {
        int sum = 0;
        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    for (int l = k + 1; l < input.length; l++) {
                        if (sum == (input[i] + input[j] + input[k] + input[l])) {
                            List<Integer> quartlet = new ArrayList<>();
                            quartlet.add(input[i]);
                            quartlet.add(input[j]);
                            quartlet.add(input[k]);
                            quartlet.add(input[l]);
                            result.add(quartlet);
                        }
                    }
                }
            }
        }
        System.out.println(result.toString());
    }

    private static void threeSum(Integer[] input) {
        Arrays.sort(input);
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    if (sum == input[i] + input[j] + input[k]) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(input[i]);
                        triplet.add(input[j]);
                        triplet.add(input[k]);
                        result.add(triplet);
                    }
                }
            }
        }
        System.out.println(result.toString());
    }

    private static void threeSumII(Integer[] input) {
        Arrays.sort(input);
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> inputIndexMap = new HashMap<>();
        for (int cnt = 0; cnt < input.length; cnt++) {
            if (inputIndexMap.containsKey(input[cnt])) {
                List<Integer> indexes = inputIndexMap.get(input[cnt]);
                indexes.add(cnt);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(cnt);
                inputIndexMap.put(input[cnt], indexes);
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int reminder = sum - input[i] - input[j];
                if (inputIndexMap.containsKey(reminder)) {
                    List<Integer> indexList = inputIndexMap.get(reminder);
                    for (Integer index : indexList) {
                        if (index > j) {
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(input[i]);
                            triplet.add(input[j]);
                            triplet.add(reminder);
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        System.out.println(result.toString());
    }
}
