package com.sample.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of PythagoreanTriplet
 */
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] input = { 3, 6, 8, 5, 10, 4, 12, 14 };
        List<List<Integer>> result = pythagoreanTriplets(input);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> pythagoreanTriplets(int[] input) {
        if (input == null || input.length == 0) {
            return Collections.emptyList();
        }
        Set<Integer> nums = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            nums.add(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                int m = 0, n = 0;
                List<Integer> factors = primeFactors(input[i] / 2);
                if (factors.size() == 2) {
                    m = factors.get(0);
                    n = factors.get(1);
                    int c = m * m + n * n;
                    int a = m * m - n * n;

                    if (nums.contains(c) && nums.contains(a)) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(c);
                        triplet.add(a);
                        triplet.add(input[i]);
                        result.add(triplet);
                    }
                }

            }
        }

        return result;
    }

    private static List<Integer> primeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        int maxFactor = (int) Math.sqrt(number);
        for (int cnt = 3; cnt < maxFactor; cnt = cnt + 2) {
            while (number % cnt == 0) {
                number /= cnt;
                factors.add(cnt);
            }
        }
        if (number > 0) {
            factors.add(number);
        }
        return factors;
    }

    private static boolean isPrime(int n) {
        if (n <= 7) {
            if (n == 2 || n == 3 || n == 5 || n == 7)
                return true;
            else
                return false;
        }

        if (n > 7) {
            if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0)
                return false;
        }
        return true;
    }
}
