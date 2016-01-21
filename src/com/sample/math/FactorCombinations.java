package com.sample.math;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of FactorCombinations
 */
public class FactorCombinations {

    public static void main(String[] args) {
        int n = 40;
        List<List<Integer>> result = factorCombinations(n);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> factorCombinations(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> base = new ArrayList<>();
        base.add(2);
        base.add(n / 2);
        result.add(base);

        while (n > 0) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> combination : result) {
                for (Integer i : combination) {
                    int limit = (int) Math.sqrt(i);
                    for (int cnt = 2; cnt < limit; cnt++) {
                        List<Integer> factors = new ArrayList<>();
                        if (i % cnt == 0) {
                            factors.add(cnt);
                            factors.add(i / cnt);
                        }
                        if (!factors.isEmpty())
                            tmp.add(factors);
                    }
                }
            }
            result.addAll(tmp);
        }

        return null;
    }
}
