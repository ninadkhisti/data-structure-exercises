package com.sample.string;

/**
 * TODO: Describe purpose and behavior of IsoMorphicString
 */
public class IsoMorphicString {

    public static void main(String[] args) {
        boolean result = isoMorphic("paparxyzxyz", "titieabcabc");
        System.out.println(result);
    }

    private static boolean isoMorphic(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int count = 1;
        int[] c1 = new int[Character.MAX_VALUE];
        int[] c2 = new int[Character.MAX_VALUE];

        for (int cnt = 0; cnt < s1.length(); cnt++) {
            if (c1[s1.charAt(cnt)] != c2[s2.charAt(cnt)])
                return false;

            if (c1[s1.charAt(cnt)] == 0) {
                c1[s1.charAt(cnt)] = count;
                c2[s2.charAt(cnt)] = count;
                count++;
            }
        }

        return true;
    }
}
