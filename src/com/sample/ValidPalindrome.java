package com.sample;

/**
 * valid palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        char[] inputArray = input.toCharArray();
        boolean result = valid(inputArray);
        System.out.println("Input is valid palindrome " + result);

    }

    private static boolean valid(char[] inputArray) {
        int reverseCnt = inputArray.length - 1;
        for (int cnt = 0; cnt < reverseCnt;) {
            if (!Character.isLetterOrDigit(inputArray[cnt])) {
                cnt++;
                continue;
            }
            if (!Character.isLetterOrDigit(inputArray[reverseCnt])) {
                reverseCnt--;
                continue;
            }
            if (Character.toLowerCase(inputArray[cnt]) != Character.toLowerCase(inputArray[reverseCnt])) {
                return false;
            } else {
                System.out.println(inputArray[cnt] + " " + inputArray[reverseCnt]);
                cnt++;
                reverseCnt--;
            }

        }
        return true;
    }
}
