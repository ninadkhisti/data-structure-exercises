package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 */
public class GeneralizedAbbreviations {

    public static void main(String[] args) {
        String word = "word";
        List<String> abbres = generalizedAbbreviations(word);
        System.out.println(abbres.toString());
    }

    private static List<String> generalizedAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int cnt = 0; cnt < chars.length; cnt++) {
            StringBuilder abbre = new StringBuilder();
            for (int icnt = 0; icnt < cnt; icnt++) {

            }
            abbre.append(1);
        }

        return null;
    }
}
