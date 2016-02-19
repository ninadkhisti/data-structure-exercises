package com.sample.string;

/**
 * Reverse digits of an integer. For example: x = 123, return 321.
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int number = 1000000003;
        int result = 0;

        while (number > 0) {
            // handle overflow/underflow
            if (Math.abs(result) > 214748364) {
                result = 0;
                break;
            }
            int digit = number % 10;
            number = (number - digit) / 10;
            result = result * 10 + digit;

        }
        System.out.println(result);
        int r = reverseNumber(1000000003);
        System.out.println(r);
    }

    private static int reverseNumber(int i) {
        int result = 0;

        while (i > 0) {
            int digit = i % 10;
            int newresult = result * 10 + digit;
            int verification = (result - digit) / 10;
            if (verification != newresult) {
                return 0;
            }
            result = newresult;
            i = (i - digit) / 10;
        }

        return result;
    }
}
