package com.sample.string;

/**
 * Determine if given string is a valid number or not - O(n)
 */
public class StringToNumber {

    public static void main(String[] args) {

        System.out.println(validNumberIII("1234"));
        System.out.println(validNumberIII("0.0.1"));
        System.out.println(validNumberIII("1323-"));
        System.out.println(validNumberIII("123455.0000"));
        System.out.println(validNumberIII("00.1"));
        System.out.println(validNumberIII("0.-1"));
        System.out.println(validNumberIII("1.2344-"));
        System.out.println(validNumberIII("-5"));
        System.out.println(validNumberIII("."));
        System.out.println(validNumberIII("-"));
        System.out.println(validNumberIII("bbb"));
        System.out.println(validNumberIII("1bbb"));
        System.out.println(validNumberIII("1.234E+9"));
        System.out.println(validNumberIII(" 5.1e-9"));

    }

    private static boolean validNumberIII(String input) {
        input = input.trim();
        boolean nums = false;
        boolean eseen = false;
        boolean numsafterE = true;
        boolean decimalSeen = false;

        for (int cnt = 0; cnt < input.length(); cnt++) {
            char ch = input.charAt(cnt);
            if (ch >= '0' && ch <= '9') {
                nums = true;
                numsafterE = true;
            } else if (ch == '.') {
                if (decimalSeen || eseen)
                    return false;
                decimalSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eseen || !nums)
                    return false;
                eseen = true;
                numsafterE = false;
            } else if (ch == '-' || ch == '+') {
                if (cnt != 0 && !(input.charAt(cnt - 1) == 'E' || input.charAt(cnt - 1) == 'e'))
                    return false;
            } else {
                return false;
            }
        }

        return nums && numsafterE;
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
