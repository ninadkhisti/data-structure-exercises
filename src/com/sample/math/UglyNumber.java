package com.sample.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(uglyNumber(30));
        System.out.println(generateUglyNumbers(30).toString());
        System.out.println(uglyNumbers(12));
    }

    private static boolean uglyNumber(int i) {
        for (int cnt = 2; cnt < 6 && i > 0; cnt++) {
            while (i % cnt == 0) {
                i = i / cnt;
            }
        }
        return i == 1;
    }

    private static List<Integer> generateUglyNumbers(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int number2 = 2;
        int number3 = 3;
        int number5 = 5;

        for (int cnt = 1; cnt < n; cnt++) {
            int ugly = Math.min(Math.min(number2, number3), number5);
            result.add(ugly);
            if (ugly == number2) {
                index2++;
                number2 = 2 * result.get(index2);
            }
            if (ugly == number3) {
                index3++;
                number3 = 3 * result.get(index3);
            }
            if (ugly == number5) {
                index5++;
                number5 = 5 * result.get(index5);
            }
        }
        return result;
    }

    private static int uglyNumbers(int n) {
        int[] seed = { 2, 7, 13, 19 };

        int[] multiple = new int[seed.length];
        int[] ugly = new int[seed.length];
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int cnt = 0; cnt < seed.length; cnt++) {
            ugly[cnt] = seed[cnt];
        }

        for (int cnt = 1; cnt < n; cnt++) {
            int anugly = ugly[0];
            for (int icnt = 0; icnt < seed.length; icnt++) {
                if (anugly > ugly[icnt]) {
                    anugly = ugly[icnt];
                }
            }
            result.add(anugly);
            for (int icnt = 0; icnt < seed.length; icnt++) {
                if (anugly == ugly[icnt]) {
                    multiple[icnt]++;
                    ugly[icnt] = seed[icnt] * result.get(multiple[icnt]);
                }
            }
        }
        return result.get(result.size() - 1);
    }
}
