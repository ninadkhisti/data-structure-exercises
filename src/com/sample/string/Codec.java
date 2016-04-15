package com.sample.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of Codec
 */
public class Codec {

    public static void main(String[] args) {
        Codec c = new Codec();
        List<String> input = Arrays.asList("Ninad", "P", "Khisti", "nkhisti@paypal.com", "~");
        System.out.println(c.encode(input));
        System.out.println(c.decode(c.encode(input)));
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty())
            return null;
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("~").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null || s.isEmpty())
            return Collections.emptyList();
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int dash = s.indexOf("~", i);
            int length = Integer.parseInt(s.substring(i, dash));
            String item = s.substring(dash + 1, dash + length + 1);
            result.add(item);
            i = dash + length + 1;
        }
        return result;
    }
}
