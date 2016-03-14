package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  JustifiedText
 */
public class JustifiedText {

    public static void main(String[] args) {
        String input = "Ruby is a dynamic, open source programming language with a focus on simplicity and productivity. It has an elegant syntax that is natural to read and easy to write.";
        String[] word = input.split("\\s+");
        int maxLength = 15;
        List<String> result = justify(word, maxLength);
        for (String aresult : result) {
            System.out.println(aresult);
        }

    }

    private static List<String> justify(String[] words, int maxLength) {
        if (words == null || words.length == 0)
            return Collections.emptyList();

        int currlen = 0, previous = 0;
        List<String> justified = new ArrayList<String>();

        for (int cnt = 0; cnt < words.length; cnt++) {
            if (currlen + words[cnt].length() > maxLength) {
                justified.add(computeResult(words, previous, cnt - 1, currlen, maxLength));
                currlen = 0;
                previous = cnt;
            }
            currlen += words[cnt].length() + 1;
        }
        justified.add(computeResult(words, previous, words.length - 1, currlen, maxLength));
        return justified;
    }

    private static String computeResult(String[] words, int previous, int current, int currlen, int maxLength) {
        int numSpaces = maxLength - (currlen - 1);
        int wordSpaces = current - previous;
        int padSpaces = wordSpaces == 0 ? 0 : numSpaces / wordSpaces;
        int reminderSpaces = wordSpaces == 0 ? 0 : numSpaces % wordSpaces;
        boolean lastRow = current == words.length - 1;

        StringBuilder sb = new StringBuilder();
        for (int cnt = previous; cnt <= current; cnt++) {
            sb.append(words[cnt]);
            if (cnt != current) {
                sb.append(" ");

                if (!lastRow) {
                    for (int i = 0; i < padSpaces; i++) {
                        sb.append(" ");
                    }
                    if (reminderSpaces > 0) {
                        sb.append(" ");
                        reminderSpaces--;
                    }
                }
            }
        }
        if (wordSpaces == 0 || lastRow) {
            for (int i = 0; i < numSpaces; i++) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
