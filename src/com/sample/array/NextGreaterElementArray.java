package com.sample.array;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterElementArray {

    public static void main(String[] args) {
        //int[] input = { 4, 5, 2, 25 };
        //int[] input = { 13, 7, 6, 12 };
        int[] input = { 11, 13, 5, 1, 100, 20, 33, 2, 9, 11, 21, 4, 5, 6, 7, 3 };

        for (int cnt = 0; cnt < input.length; cnt++) {
            int nextgreater = -1;
            inner: for (int icnt = cnt + 1; icnt < input.length; icnt++) {
                if (input[cnt] < input[icnt]) {
                    nextgreater = input[icnt];
                    break inner;
                }
            }
            System.out.println(input[cnt] + "=> " + nextgreater);
        }

        System.out.println("---");
        int nextgreater = -1;
        System.out.println(input[input.length - 1] + "=> " + nextgreater);

        for (int cnt = input.length - 2; cnt >= 0; cnt--) {
            if (input[cnt] < input[cnt + 1] && (nextgreater == -1 || nextgreater > input[cnt + 1])) {
                nextgreater = input[cnt + 1];
            }
            if (input[cnt] < nextgreater) {
                System.out.println(input[cnt] + "=> " + nextgreater);
            } else {
                nextgreater = -1;
                System.out.println(input[cnt] + "=> -1");
            }
        }
    }
}
