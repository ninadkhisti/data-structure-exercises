package com.sample.array;

/**
 * TODO: Describe purpose and behavior of PatchingArray
 */
public class PatchingArray {

    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 13, 43 };
        int n = 100;
        int patches = 0;
        int missing = 1;
        int index = 0;
        while (missing <= n) {
            if (index < array.length && array[index] <= missing) {
                missing += array[index];
                index++;
            } else {
                System.out.println(missing);
                missing += missing;

                patches++;
            }
        }
        System.out.println(patches);
    }
}
