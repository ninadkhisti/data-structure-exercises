package com.sample.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TextJustification
 */
public class TextJustification {

    public static void main(String[] args) {
        //String[] input = { "This", "is", "an", "example", "of", "text", "justification." };
        String[] input = { "What", "must", "be", "shall", "be." };
        int maxWidth = 12;
        TextJustification textJustification = new TextJustification();
        List<String> result = textJustification.fullJustify(input, maxWidth);
        System.out.println(result.toString());
    }

    public List<String> fullJustify(String[] inputs, int maxWidth) {
        if (inputs == null || inputs.length == 0)
            return Collections.emptyList();
        List<String> result = new ArrayList<>();
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
        int previous = 0, currlen = 0;
        for (int cnt = 0; cnt < inputs.length; cnt++) {
            if (currlen + inputs[cnt].length() > maxWidth) {
                result.add(addResult(inputs, maxWidth, cnt - 1, previous, currlen));
                currlen = 0;
                previous = cnt;
            }
            currlen += inputs[cnt].length() + 1;
        }
        result.add(addResult(inputs, maxWidth, inputs.length - 1, previous, currlen));
        return result;
    }

    private String addResult(String[] inputs, int maxWidth, int i, int previous, int length) {
        StringBuilder sb = new StringBuilder();
        int wordsSpaces = i - previous;
        int numSpaces = maxWidth - length + 1;
        int spacePerWord = wordsSpaces == 0 ? 0 : (int) numSpaces / wordsSpaces;
        int reminder = wordsSpaces == 0 ? 0 : numSpaces % wordsSpaces;

        if (i == inputs.length - 1 || i - previous == 0) {
            for (int cnt = previous; cnt <= i; cnt++) {
                sb.append(inputs[cnt]);
                if (cnt != i) {
                    sb.append(" ");
                }
            }
            while (numSpaces > 0) {
                sb.append(" ");
                numSpaces--;
            }
        } else {

            for (int cnt = previous; cnt <= i; cnt++) {
                sb.append(inputs[cnt]);
                if (cnt != i) {
                    sb.append(" ");
                    for (int icnt = 0; icnt < spacePerWord; icnt++) {
                        sb.append(" ");
                    }
                    if (reminder > 0) {
                        sb.append(" ");
                        reminder--;
                    }
                }
            }
        }
        return sb.toString();

    }
}
