package com.sample.string;

/**
 * https://en.wikipedia.org/wiki/Strobogrammatic_number
 */
public class StrobogrammticNumber {

    public static void main(String[] args) {
        System.out.println(strobogrammaticNumber(8698));
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
}