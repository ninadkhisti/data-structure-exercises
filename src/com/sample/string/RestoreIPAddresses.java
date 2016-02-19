package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of RestoreIPAddresses
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        String input = "25525511135";
        List<String> result = new ArrayList<>();
        restoreips(input, "", 0, result);
        System.out.println(result.toString());
    }

    private static void restoreips(String input, String curr, int parts, List<String> result) {
        if (parts == 4) {
            curr = curr.substring(0, curr.length() - 2);
            if (input.length() == 0) {
                result.add(curr);
            }
            return;
        }

        for (int cnt = 1; cnt <= 3; cnt++) {
            if (input.length() < cnt)
                continue;
            String val = input.substring(0, cnt);
            if (Integer.parseInt(val) > 255 || cnt != String.valueOf(val).length())
                continue;
            restoreips(input.substring(cnt), curr.concat(val).concat("."), parts + 1, result);
        }

    }
}
