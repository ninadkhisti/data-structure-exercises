package com.sample.string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of DecodeString
 */
public class DecodeString {

    public Integer decodeFind(String badEncString) {
        if (badEncString == null || badEncString.length() == 0) {
            return -1;
        }

        StringBuffer sb = new StringBuffer();
        List<String> result = new ArrayList<>();
        Integer i = decodeFindHelper(result, 0, sb, badEncString);
        System.out.println(result.toString());
        return i;
    }

    private Integer decodeFindHelper(List<String> matches, int start, StringBuffer curr, String badEncString) {
        if (start == badEncString.length()) {
            String testEncStr = curr.toString();
            matches.add(testEncStr);
            Integer result = decode(testEncStr);

            if (result != null) {
                return result;
            } else {
                return null;
            }
        }

        char c = badEncString.charAt(start);
        if (!Character.isLetter(c)) {
            curr.append(c);
            Integer result = decodeFindHelper(matches, start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);
        } else {
            // To lower case
            char lower = Character.toLowerCase(c);
            curr.append(lower);
            Integer result = decodeFindHelper(matches, start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);

            // To upper case
            char upper = Character.toUpperCase(c);
            curr.append(upper);
            result = decodeFindHelper(matches, start + 1, curr, badEncString);
            if (result != null) {
                return result;
            }
            curr.deleteCharAt(curr.length() - 1);
        }

        return null;
    }

    public Integer decode(String testEncStr) {
        String truth = "kljJJ324hijkS_";

        if (testEncStr.equals(truth)) {
            return 848662;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String badEncStr = "kLjjj324hijks_";
        Integer result = decodeString.decodeFind(badEncStr);

        System.out.println(result);
    }

}
