package com.sample.dynamicprogramming;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of EditDistance
 */
public class EditDistance {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int result = editdistance(s1, s2);
        System.out.println(result);
    }

    private static int editdistance(String s1, String s2) {
        int[][] distances = new int[s1.length() + 1][s2.length() + 1];
        for (int cnt = 0; cnt < distances.length; cnt++) {
            distances[cnt][0] = cnt;
        }
        for (int cnt = 0; cnt < distances[0].length; cnt++) {
            distances[0][cnt] = cnt;
        }
        for (int cnt = 1; cnt < distances.length; cnt++) {
            for (int icnt = 1; icnt < distances[0].length; icnt++) {
                if (s1.charAt(cnt - 1) == s2.charAt(icnt - 1)) {
                    distances[cnt][icnt] = distances[cnt - 1][icnt - 1];
                } else {
                    distances[cnt][icnt] = Math.min(Math.min(distances[cnt - 1][icnt], distances[cnt][icnt - 1]),
                            distances[cnt - 1][icnt - 1]) + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(distances));
        return distances[s1.length()][s2.length()];
    }
}
