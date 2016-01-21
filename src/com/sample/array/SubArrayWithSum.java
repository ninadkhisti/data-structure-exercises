package com.sample.array;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of SubArrayWithSum
 */
public class SubArrayWithSum {

    public static void main(String[] args) {
        int[] array = { 4, 2, -3, 1, 6 };

        subArrayWithSum(array);
        subArrayWithSumII(array);
        minimumSubArratWithSum();
    }

    private static void minimumSubArratWithSum() {
        int[] input = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
        int target = 280;
        int sum = input[0];
        int start = 0;
        int minlength = 0;
        int cnt = 0;
        loop: while (cnt < input.length) {
            if (sum < target) {
                sum += input[cnt];
                cnt++;
            }
            if (sum > target) {
                sum -= input[start];
                if (minlength == 0)
                    minlength = cnt - start;
                minlength = Math.min(minlength, cnt - start);
                start++;
            }
            if (sum == target) {
                break loop;
            }

        }
        System.out.println(minlength);
    }

    private static void subArrayWithSumII(int[] array) {
        Map<Integer, Integer> sums = new HashMap<>();

        int sum = 0;
        for (int cnt = 0; cnt < array.length; cnt++) {
            sum += array[cnt];

            if (array[cnt] == 0 || sum == 0 || sums.containsKey(sum)) {
                System.out.println("begin index " + (sums.get(sum) + 1) + " end index " + cnt);
            }
            sums.put(sum, cnt);
        }

    }

    private static void subArrayWithSum(int[] array) {
        int target = 0;

        outer: for (int cnt = 0; cnt < array.length; cnt++) {
            int sum = 0;
            for (int icnt = cnt; icnt < array.length; icnt++) {
                sum += array[icnt];
                if (sum == target) {
                    System.out.println("begin index " + cnt + " end index " + icnt);
                    break outer;
                }
            }
        }

    }
}
