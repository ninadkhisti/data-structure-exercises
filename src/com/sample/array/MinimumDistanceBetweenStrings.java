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
        List<String> input = Arrays.asList("a", "a", "d", "d", "d", "d", "d", "d", "d", "b", "c", "d", "d", "a", "e",
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
    }
}
