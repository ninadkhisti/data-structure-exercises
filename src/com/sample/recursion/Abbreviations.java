package com.sample.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of Abbreviations
 */
public class Abbreviations {

    public static void main(String[] args) {

        String input = "word";
        List<String> result = new ArrayList<>();
        abbreviations(input, result, "", 0, 0);
        System.out.println(result.toString());
    }

    private static void abbreviations(String input, List<String> result, String abbre, int start, int count) {
        if (start == input.length()) {
            if (count > 0)
                abbre += count;
            result.add(abbre);
            return;
        } else {
            abbreviations(input, result, abbre, start + 1, count + 1);
            abbreviations(input, result, abbre + (count > 0 ? count : "") + input.charAt(start), start + 1, 0);
        }
    }
}
