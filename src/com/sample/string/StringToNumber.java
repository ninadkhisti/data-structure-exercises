package com.sample.string;

/**
 * Determine if given string is a valid number or not - O(n)
 */
public class StringToNumber {

    public static void main(String[] args) {

        System.out.println(validNumber("1234"));
        System.out.println(validNumber("0.0.1"));
        System.out.println(validNumber("1323-"));
        System.out.println(validNumber("123455.0000"));
        System.out.println(validNumber("00.1"));
        System.out.println(validNumber("0.-1"));
        System.out.println(validNumber("1.2344-"));
        System.out.println(validNumber("-5"));
        System.out.println(validNumber("."));
        System.out.println(validNumber("-"));
        System.out.println(validNumber("bbb"));
        System.out.println(validNumber("1bbb"));

    }

    private static boolean validNumber(String input) {

        char[] inputArray = input.toCharArray();
        int dotIndex = 0;
        //pre-processing
        if (inputArray.length == 1 && inputArray[0] == '.' || inputArray[0] == '-') {
            return false;
        }
        for (int cnt = 0; cnt < inputArray.length; cnt++) {

            if (inputArray[cnt] == '.') {
                if (cnt == 0 || dotIndex == 0) {
                    dotIndex = cnt;
                    continue;
                } else
                    return false;
            }
            if (inputArray[cnt] == '-') {
                if (cnt > 0) {
                    return false;
                } else {
                    continue;
                }
            }

            if ('9' - inputArray[cnt] > 9 || '9' - inputArray[cnt] < 0)
                return false;

        }

        return true;
    }
}
