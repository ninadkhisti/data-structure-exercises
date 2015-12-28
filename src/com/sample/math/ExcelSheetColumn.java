package com.sample.math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *  A -> 1
 *  B -> 2
 *  C -> 3
 * 
 */
public class ExcelSheetColumn {

    public static void main(String[] args) {
        System.out.println(getColumnNumber("ABCCZZ"));
        System.out.println(getColumnNumber("Zz"));
        System.out.println(getColumnName(12850786));
    }

    private static int getColumnNumber(String input) {
        int result = 0;
        char[] inputArray = input.toCharArray();
        int weight = 0;
        for (int cnt = inputArray.length - 1; cnt >= 0; cnt--) {
            if (inputArray[cnt] - 'A' < 0 || inputArray[cnt] - 'A' > 26) {
                return result;
            }
            result += ((int) Math.pow(26, weight) * (inputArray[cnt] - 'A' + 1));
            weight++;
        }
        return result;
    }

    private static String getColumnName(int index) {
        int base = 26;
        StringBuilder result = new StringBuilder();
        while (index > 0) {
            index--;
            int digit = index % base;
            result.append(Character.toChars('A' + digit));
            index = (index) / 26;
        }
        return result.reverse().toString();
    }
}
