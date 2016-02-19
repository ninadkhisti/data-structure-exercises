package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of WordLadder
 */
public class WordLadder {

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] list = { "hot", "dot", "dog", "lot", "log", "cog" };
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add(begin);
        wordLadder(list, current, end, result);
        System.out.println(result.toString());
    }

    private static void wordLadder(String[] list, List<String> current, String end, List<List<String>> result) {
        if (current.get(current.size() - 1) == end) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (String astring : list) {
            String begin = current.get(current.size() - 1);
            if (oneedit(begin, astring) && !current.contains(astring)) {
                current.add(current.size(), astring);
                wordLadder(list, current, end, result);
                current.remove(current.size() - 1);
            }

        }

    }

    private static boolean oneedit(String s1, String s2) {
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
        return distances[s1.length()][s2.length()] == 1;
    }

}
