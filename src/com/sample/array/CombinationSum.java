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

        List<List<Integer>> result = findCombinations(input, target);
        System.out.println(result.toString());
    }

    private List<Combination> combinationSum(int[] input) {
        List<Combination> combinations = new ArrayList<>();
        Arrays.sort(input);
        Combination a = new Combination();
        combinations.add(a);

        for (int cnt = 0; cnt < input.length; cnt++) {
            List<Combination> cs = new ArrayList<>();
            for (Combination c : combinations) {
                List<Integer> nums = new ArrayList<>(c.combination);
                nums.add(input[cnt]);
                Combination aComb = new Combination();
                aComb.combination = nums;

            }
            combinations.addAll(cs);
        }

        return combinations;
    }

    private static List<List<Integer>> findCombinations(int[] input, int target) {
        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combinationSum(input, target, result, combination, 0);
        return result;
    }

    private static void combinationSum(int[] input, int target, List<List<Integer>> result, List<Integer> combination,
            int begin) {
        for (int cnt = begin; cnt < input.length; cnt++) {
            if (target == 0) {
                List<Integer> c = new ArrayList<Integer>(combination);
                result.add(c);
            } else if (target < 0) {
                return;
            } else {
                List<Integer> ncombination = new ArrayList<Integer>(combination);
                ncombination.add(input[cnt]);
                combinationSum(input, target - input[cnt], result, ncombination, cnt + 1);
            }
        }
    }

}