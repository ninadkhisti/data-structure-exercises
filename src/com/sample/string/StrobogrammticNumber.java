package com.sample.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Strobogrammatic_number
 */
public class StrobogrammticNumber {

    public static void main(String[] args) {
        //System.out.println(strobogrammaticNumber("2"));
        List<String> numbers = strobogrammaticNumberII(5);
        //System.out.println(numbers.toString());
        int result = strobogrammaticNumberIII("50", "69");
        System.out.println(result);
    }

    private static int strobogrammaticNumberIII(String start, String end) {
        if (start.compareTo(end) > 0)
            return 0;
        if (start.equals(end)) {
            if (strobogrammaticNumber(start)) {
                return 1;
            } else {
                return 0;
            }
        }
        List<String> result = new ArrayList<String>();
        for (int cnt = start.length(); cnt <= end.length(); cnt++) {
            List<String> interim = strobogrammaticNumberII(cnt);
            result.addAll(interim);
        }
        List<String> filtered = new ArrayList<>();
        System.out.println(result.toString());
        for (String a : result) {
            if (a.equals(start) || a.equals(end)) {
                filtered.add(a);
            }
            if (a.compareTo(start) > 0 && a.compareTo(end) < 0) {
                filtered.add(a);
            }
        }
        return filtered.size();
    }

    private static List<String> strobogrammaticNumberII(int n) {
        List<String> one = Arrays.asList("0", "1", "8");
        if (n == 0)
            return Collections.emptyList();
        if (n == 1)
            return one;

        List<String> two = Arrays.asList("");
        List<String> result = new ArrayList<>();
        if (n % 2 == 1) {
            result = one;
        } else
            result = two;

        for (int cnt = n % 2 + 1; cnt < n; cnt = cnt + 2) {
            List<String> tmp = new ArrayList<>();
            for (String item : result) {
                tmp.add("8" + item + "8");
                tmp.add("6" + item + "9");
                tmp.add("9" + item + "6");
                tmp.add("1" + item + "1");
                if (cnt != n - 1) {
                    tmp.add("0" + item + "0");
                }
            }
            result = tmp;
        }

        return result;
    }

    private static boolean strobogrammaticNumber(String input) {
        StringBuilder sb = new StringBuilder();
        for (int cnt = input.length() - 1; cnt >= 0; cnt--) {
            if (input.charAt(cnt) == '6') {
                sb.append('9');
            } else if (input.charAt(cnt) == '9') {
                sb.append('6');
            } else if (input.charAt(cnt) == '0' || input.charAt(cnt) == '1' || input.charAt(cnt) == '8') {
                sb.append(input.charAt(cnt));
            } else {
                return false;
            }
        }
        return sb.toString().equals(input);
    }

}