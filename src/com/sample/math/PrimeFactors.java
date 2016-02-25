package com.sample.math;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of PrimeFactors
 */
public class PrimeFactors {

    public static void main(String[] args) {
        int number = 27;
        Set<Integer> factors = primeFactors(number);
        System.out.println(factors);
    }

    private static Set<Integer> primeFactors(int number) {
        Set<Integer> factors = new HashSet<>();
        while (number % 2 == 0) {
            number /= 2;
            factors.add(2);
        }
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
}
