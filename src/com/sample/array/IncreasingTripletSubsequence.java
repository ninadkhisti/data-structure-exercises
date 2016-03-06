package com.sample.array;

/**
 * TODO: Describe purpose and behavior of IncreasingTripletSubsequence
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] input = { 1, 10, 5, 4, 3, 2, 0, 5, 2, 1, 6, 2 };
        System.out.println(increasingTripletSubsequence(input));
    }

    private static boolean increasingTripletSubsequence(int[] input) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int a : input) {
            if (a <= min)
                min = a;
            else if (a < secondMin)
                secondMin = a;
            else
                return true;
        }
        return false;
    }
}
