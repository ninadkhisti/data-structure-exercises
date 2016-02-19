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
        System.out.println(strobogrammaticNumber(8698));
        List<String> numbers = strobogrammaticNumberII(5);
        System.out.println(numbers.toString());
        //List<String> result = helper(5, 5);
        //System.out.println(result.toString());
    }

    private static List<String> strobogrammaticNumberII(int n) {
        List<String> one = Arrays.asList("8", "1", "0");
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

    private static boolean strobogrammaticNumber(int input) {
        int result = 0;
        int strobogrammatic = input;
        while (input > 0) {
            int digit = input % 10;
            input = input / 10;
            if (digit == 6)
                digit = 9;
            else if (digit == 9)
                digit = 6;
            result = result * 10 + digit;
        }
        return strobogrammatic == result;
    }

    private static List<String> helper(int n, int m) {
        if (n == 0)
            return new ArrayList<String>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m)
                res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }

}