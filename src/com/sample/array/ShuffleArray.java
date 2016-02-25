package com.sample.array;

import java.util.Arrays;
import java.util.Random;

/**
 * TODO: Describe purpose and behavior of ShuffleArray
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] result = shuffleArray(input);
        System.out.println(Arrays.toString(result));
    }

    private static int[] shuffleArray(int[] input) {
        if (input == null || input.length == 0)
            return null;
        for (int i = 1; i < input.length; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(i);
            int temp = input[randomIndex];
            input[randomIndex] = input[i];
            input[i] = temp;

        }
        return input;
    }
}
