package com.sample.array;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
public class EquilibriumIndexofArray {

    public static void main(String[] args) {
        //int[] input = { 1, 2, 1, 3, 0 };
        int[] input = { -7, 1, 5, 2, -4, 3, 0 };
        List<Integer> result = equilibriumIndex(input);
        System.out.println(result.toString());
    }

    private static List<Integer> equilibriumIndex(int[] input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0) {
            result.add(-1);
            return result;
        }
        int rightsum = 0;

        for (int i = 0; i < input.length; i++) {
            rightsum += input[i];
        }
        int leftsum = 0;
        for (int i = 0; i < input.length; i++) {
            rightsum -= input[i];
            if (leftsum == rightsum)
                result.add(i);
            leftsum += input[i];
        }
        if (result.isEmpty()) {
            result.add(-1);
            return result;
        }
        return result;
    }
}
