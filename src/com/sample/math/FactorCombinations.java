package com.sample.math;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of FactorCombinations
 */
public class FactorCombinations {

    public static void main(String[] args) {
        int n = 32;
        //List<List<Integer>> result = factorCombinations(n);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), n, 2);
        System.out.println(result.toString());

    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
