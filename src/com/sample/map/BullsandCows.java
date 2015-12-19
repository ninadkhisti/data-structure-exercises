package com.sample.map;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsandCows {

    public static void main(String[] args) {
        int secret = 1807;
        int guess = 7810;

        System.out.println(findBullsandCows(secret, guess));
    }

    private static String findBullsandCows(int secret, int guess) {
        int cows = 0;
        int bulls = 0;
        Map<Integer, Integer> cowSet = new HashMap<Integer, Integer>();
        int cnt = 0;
        while (secret > 0) {
            int n1 = secret % 10;
            secret = (secret - n1) / 10;
            cowSet.put(n1, cnt);
            cnt++;
        }
        cnt = 0;
        while (guess > 0) {
            int n2 = guess % 10;
            guess = (guess - n2) / 10;

            if (cowSet.containsKey(n2)) {
                if (cnt == cowSet.get(n2)) {
                    bulls++;
                } else {
                    cows++;
                }
            }
            cnt++;

        }
        return bulls + "A" + cows + "B";

    }
}
