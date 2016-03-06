package com.sample.string;

/**
 * TODO: Describe purpose and behavior of NumberToWords
 */
public class NumberToWords {

    private static final String[] lessthan20 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen" };
    private static final String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
            "eighty", "ninety" };
    private static final String[] thousands = { "", "thousands", "million", "billion" };

    public static void main(String[] args) {

        for (int cnt = 0; cnt < 10000000; cnt++)
            System.out.println(numberToWords(cnt));
    }

    private static String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int i = 0;
        String result = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + thousands[i] + " " + result;
                i++;
            }
            num /= 1000;
        }
        return result;
    }

    private static String helper(int i) {
        if (i < 20)
            return lessthan20[i];
        if (i < 100)
            return tens[i / 10] + " " + helper(i % 10);
        return lessthan20[i / 100] + " hundred " + helper(i % 100) + " ";
    }
}
