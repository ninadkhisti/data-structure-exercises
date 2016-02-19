package com.sample.string;

/**
 * TODO: Describe purpose and behavior of CountAndSay
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 25;
        int i = 0;
        String start = "1";
        while (i < n) {
            start = countAndSay(start);
            System.out.println(start);
            i++;
        }
    }

    private static String countAndSay(String n) {
        char[] array = n.toCharArray();
        char previous = 0;
        char current = 0;
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int cnt = 0; cnt < array.length; cnt++) {
            current = array[cnt];
            if (previous == current) {
                count++;
            }
            if (previous != current && cnt > 0) {
                builder.append(count);
                builder.append(previous);
                count = 1;
            }
            previous = current;
        }
        builder.append(count);
        builder.append(current);
        return builder.toString();
    }
}
