package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * find triplet with desired sum in an array
 */
public class TripletsInArray {

    private static final int SUM = 1;

    public static void main(String[] args) {
        int[] input = { -1, -2, -3, -4, -5, -6, -7, -8, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int sum = SUM;
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int number : input) {
            if (number >= sum) {
                positives.add(number);
            } else {
                negatives.add(number);
            }
        }
        Collections.sort(positives);
        Collections.sort(negatives);

        for (int negative : negatives) {
            for (int positive : positives) {
                findTriplet(negative, positive, negative + positive >= sum ? negatives : positives);
            }
        }
    }

    private static void findTriplet(int negative, int positive, List<Integer> numbers) {
        int interimSum = negative + positive;
        for (int number : numbers) {
            int tripleSum = interimSum + number;
            if (tripleSum == SUM) {
                System.out.format("triplet => %d, %d, %d", negative, positive, number);
                System.out.println("");
            }
            if (tripleSum > SUM) {
                break;
            }
        }

    }
}
