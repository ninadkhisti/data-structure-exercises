package com.sample.string;

/**
 * TODO: Describe purpose and behavior of AddBinary
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty())
            return null;
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int d1 = a.charAt(i) - '0';
            int d2 = b.charAt(j) - '0';
            int addition = d1 + d2 + carry;
            int digit = addition % 2;
            carry = addition / 2;
            result.append(digit);
            i--;
            j--;
        }
        while (i >= 0) {
            int d1 = a.charAt(i) - '0';
            int addition = d1 + carry;
            int digit = addition % 2;
            carry = addition / 2;
            result.append(digit);
            i--;
        }
        while (j >= 0) {
            int d2 = b.charAt(j) - '0';
            int addition = d2 + carry;
            int digit = addition % 2;
            carry = addition / 2;
            result.append(digit);
            j--;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
