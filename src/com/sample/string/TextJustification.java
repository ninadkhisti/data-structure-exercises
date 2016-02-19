package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TextJustification
 */
public class TextJustification {

    private static int L = 16;

    public static void main(String[] args) {
        String[] input = { "This", "is", "an", "example", "of", "text", "justification." };
        List<String> result = justify(input);
        System.out.println(result.toString());
    }

    private static List<String> justify(String[] inputs) {
        int previous = 0;
        int currlen = 0;
        List<String> result = new ArrayList<>();
        for (int cnt = 0; cnt < inputs.length; cnt++) {
            currlen += inputs[cnt].length() + 1;
            if (currlen > L) {
                result.add(addResult(inputs, cnt - 1, previous, currlen - (inputs[cnt].length() + 1), false));
                currlen = inputs[cnt].length() + 1;
                previous = cnt;
            }
        }
        result.add(addResult(inputs, inputs.length - 1, previous, currlen, true));
        return result;
    }

    private static String addResult(String[] inputs, int i, int previous, int length, boolean lastRow) {
        StringBuilder sb = new StringBuilder();
        int numSpaces = L - length;
        int wordsSpaces = i - previous;
        int spacePerWord = wordsSpaces == 0 ? 0 : (int) numSpaces / wordsSpaces;
        int reminder = wordsSpaces == 0 ? 0 : numSpaces % wordsSpaces;

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
        if (lastRow || i - previous == 0) {
            while (numSpaces > 0) {
                sb.append(" ");
                numSpaces--;
            }
        }
        return sb.toString();

    }
}
