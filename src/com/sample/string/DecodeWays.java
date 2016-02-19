package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of DecodeWays
 */
public class DecodeWays {

    public static void main(String[] args) {
        String input = "12465465";
        List<String> result = new ArrayList<>();
        decodeWays(input, "", result);
        System.out.println(result.toString());
    }

    private static void decodeWays(String input, String curr, List<String> result) {
        if (input.length() == 0) {
            result.add(curr);
            return;
        }
        for (int cnt = 1; cnt <= 2; cnt++) {
            if (input.length() < cnt)
                continue;
            String slice = input.substring(0, cnt);
            if (Integer.parseInt(slice) > 26)
                continue;
            char c = (char) (Integer.parseInt(slice) - 1 + 'A');
            decodeWays(input.substring(cnt), curr.concat(Character.toString(c)), result);

        }
    }
}
