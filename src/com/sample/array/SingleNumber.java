package com.sample.array;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] input = { 1, 2, 1, 3, 2, 5 };
        int[] input1 = { 1, 1, 1, 2, 2, 2, 999, 999, 999, 44, 44, 44, 9 };
        int[] input2 = { 0, 1, 2, 4, 5, 6, 7 };
        singleNumber(input);
        singleNumberII(input1, 3);
        hammingWeight(15);
        missingNumber(input2);
        System.out.println(1 << 4);
    }

    private static void missingNumber(int[] input2) {
        int result = input2.length;
        for (int cnt = 0; cnt < input2.length; cnt++) {
            result ^= cnt;
            result ^= input2[cnt];
        }
        System.out.println("missing number =>" + result);
    }

    private static void hammingWeight(int i) {
        int weight = 0;
        for (int cnt = 0; cnt < 32; cnt++) {
            if ((i & 1 << cnt) != 0)
                weight++;
        }
        System.out.println("weight =>" + weight);
    }

    private static void singleNumberII(int[] input1, int k) {
        int[] bitSet = new int[32];
        for (int cnt = 0; cnt < input1.length; cnt++) {
            for (int icnt = 0; icnt < bitSet.length; icnt++) {
                if ((input1[cnt] & 1 << icnt) != 0) {
                    bitSet[icnt] += 1;
                }
            }
        }
        int result = 0;
        for (int cnt = 0; cnt < bitSet.length; cnt++) {
            bitSet[cnt] = bitSet[cnt] % k;
            if (bitSet[cnt] > 0) {
                result |= (1 << cnt);
            }
        }
        System.out.println(result);
    }

    private static void singleNumber(int[] input) {
        int xor = input[0];
        for (int cnt = 1; cnt < input.length; cnt++) {
            xor ^= input[cnt];
        }
        int lastbit = xor & ~(xor - 1);

        int a = 0, b = 0;
        for (int cnt = 0; cnt < input.length; cnt++) {

            if ((input[cnt] & lastbit) == 0) {
                a ^= input[cnt];
            } else {
                b ^= input[cnt];
            }
        }
        System.out.println(a + " , " + b);
    }
}
