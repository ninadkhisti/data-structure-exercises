package com.sample.array;

import java.util.Arrays;
import java.util.List;

/**
 * Compute minimum distance between two strings in array O(n)
 */
public class MinimumDistanceBetweenStrings {

    public static void main(String[] args) {
        int minIndex = 0;
        int maxIndex = 0;

        String input1 = "a";
        String input2 = "b";
        List<String> input = Arrays.asList("a", "e", "d", "d", "d", "d", "d", "d", "d", "b", "c", "d", "d", "a", "e",
                "f");

        int index = 0;
        int mindistance = 0;
        for (String aString : input) {
            index++;
            if (aString.equals(input1)) {
                minIndex = index;
            }
            if (aString.equals(input2)) {
                maxIndex = index;
            }
            if (minIndex > 0 && maxIndex > 0) {
                if (Math.abs(minIndex - maxIndex) < mindistance || mindistance == 0)
                    mindistance = Math.abs(minIndex - maxIndex);
            }
        }
        System.out.println(mindistance);

        minimumDistance(input);
    }

    private static void minimumDistance(List<String> input) {
        String input1 = "a";
        String input2 = "a";
        int index = 0, pindex = 0, mindistance = -1;
        int cnt = 0;
        for (String a : input) {
            cnt++;
            if (a.equals(input1) || a.equals(input2)) {
                pindex = index;
                index = cnt;
                if (index > 0 && pindex > 0 && (Math.abs(index - pindex) < mindistance || mindistance == -1)) {
                    mindistance = Math.abs(index - pindex);
                }
            }
        }
        System.out.println("mindistance =>" + mindistance);
    }
}
