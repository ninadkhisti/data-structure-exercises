package com.sample.math;

/**
 * https://leetcode.com/problems/happy-number/
 * 
 * Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {

    public static void main(String[] args) {
        //System.out.println(happyNumber(27));
        System.out.println(addDigits(38));
        System.out.println(addDigitsII(38));
        System.out.println(addDigitsII(0));
    }

    private static int addDigits(int i) {
        int result = 0;
        while (i > 0) {
            int digit = i % 10;
            result += digit;
            i = (i - digit) / 10;
        }
        if (result >= 10)
            return addDigits(result);
        else
            return result;
    }

    private static String addBinary(String a, String b) {
        return null;
    }

    //digital root - https://en.wikipedia.org/wiki/Digital_root
    //The Digital Root of a number is same as the remainder when that number is divided by 9 (and this remainder will always be a single digit). 
    private static int addDigitsII(int number) {
        if (number == 0)
            return 0;
        return number % 9 == 0 ? 9 : number % 9;
    }

    private static boolean happyNumber(int number) {
        if (number == 1)
            return true;
        if (number == Integer.MAX_VALUE)
            return false;
        int newNumber = 0;
        while (number > 0) {
            int digit = number % 10;
            number = (number - digit) / 10;
            newNumber += digit * digit;
        }
        return happyNumber(newNumber);
    }

}
