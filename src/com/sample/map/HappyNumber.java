package com.sample.map;

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
        System.out.println(happyNumber(27));
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
