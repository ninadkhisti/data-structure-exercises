package com.sample.array;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 */
public class JumpGame {

    public static void main(String[] args) {
        int[] input = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }; //{ 2, 8, 1, 1, 1, 1, 1, 1, 1, 1, 4 };

        int[] input1 = { 2, 3, 1, 0, 4 };
        System.out.println(jumpGame(input1));
        System.out.println(jumpGame(input1));
        System.out.println(minimumJumps(input));
    }

    private static boolean jumpGame(int[] input) {
        int index = 0;
        int end = 0;
        while (index < input.length - 1) {
            int startIndex = input[index];
            if (startIndex == 0)
                break;
            for (int i = 1; i <= startIndex; i++) {
                end = input[index + i];
            }
            index += startIndex;
        }
        return end == input[input.length - 1];
    }

    /**
     * 0 1 2 3 4
     * [2,3,1,0,4]
     */
    private static int minimumJumps(int[] input) {
        if (input.length <= 0)
            return 0;
        int[] minJumpArray = new int[input.length];

        for (int cnt = input.length - 2; cnt >= 0; cnt--) {
            int jumps = input[cnt];
            if (jumps == 0)
                continue;
            int totaljumps = Integer.MAX_VALUE;
            for (int icnt = 1; icnt <= jumps; icnt++) {
                if (cnt + icnt <= input.length - 1) {
                    totaljumps = Math.min(totaljumps, minJumpArray[cnt + icnt]);
                }
            }
            minJumpArray[cnt] = totaljumps + 1;

        }
        System.out.println(Arrays.toString(minJumpArray));
        return minJumpArray[0];
    }
}
