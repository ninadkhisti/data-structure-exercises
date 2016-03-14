package com.sample.string;

/**
 * TODO: Describe purpose and behavior of OneEditDistance
 */
public class OneEditDistance {

    public static void main(String[] args) {
        boolean result = oneEdit("a", "ac");
        System.out.println(result);
    }

    private static boolean oneEdit(String s1, String s2) {
        if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0))
            return false;

        if (s1 == null || s1.length() == 0)
            return s2.length() == 1;
        if (s2 == null || s2.length() == 0)
            return s1.length() == 1;
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                count++;
                if (count > 1)
                    return false;
                if (s1.length() > s2.length()) {
                    i++;
                } else if (s1.length() < s2.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return count == 1;
    }
}
