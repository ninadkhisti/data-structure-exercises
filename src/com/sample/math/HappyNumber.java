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
        System.out.println(happyNumberII(27));
        System.out.println(addDigits(38));
        System.out.println(addDigitsII(38));
        System.out.println(addDigitsII(0));
        System.out.println(countPrimes(120));
        System.out.println(countPrimes(7));
        System.out.println(countPrimes(8));
        System.out.println(countPrimes(11));
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

    private static boolean happyNumberII(int n) {
        int slow = n, fast = n;
        do {
            slow = getNewNumber(slow);
            fast = getNewNumber(fast);
            fast = getNewNumber(fast);
        } while (slow != fast);
        if (slow == 1)
            return true;
        else
            return false;
    }

    private static int getNewNumber(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            n = (n - digit) / 10;
            result += digit * digit;
        }
        return result;
    }

    private static int countPrimes(int n) {
        if (n <= 0)
            return 0;

        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n > 3 && n <= 6)
            return 3;
        if (n == 7)
            return 4;
        int primes = 4;
        for (int cnt = 2; cnt <= n; cnt++) {
            if (cnt % 2 == 0)
                continue;
            if (cnt % 3 == 0)
                continue;
            if (cnt % 5 == 0)
                continue;
            if (cnt % 7 == 0)
                continue;
            primes++;
        }
        return primes;
    }
}
