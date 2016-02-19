package com.sample.math;

/**
 * TODO: Describe purpose and behavior of PalindromeNumber
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int n = 155676551;
        boolean result = palindrome(n);
        System.out.println(result);
        System.out.println(palindrome(1000));
        System.out.println(palindrome(-4545));
        System.out.println(palindrome(1000000003));
    }

    private static boolean palindrome(int n) {
        if (n < 0 || (n != 0 && n % 10 == 0))
            return false;
        int reverse = 0;

        while (n > reverse) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        if (n == reverse || n == (reverse / 10))
            return true;

        return false;
    }
}
