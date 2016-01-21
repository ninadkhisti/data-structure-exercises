package com.sample.array;

/**
 *  Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
 *  And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class LeadersInArray {

    public static void main(String[] args) {
        int[] array = { 16, 17, 4, 3, 5, 2 };

        int previousLead = 0;
        for (int cnt = array.length - 1; cnt >= 0; cnt--) {
            if (array[cnt] > previousLead) {
                previousLead = array[cnt];
                System.out.println(previousLead);
            } else {
                continue;
            }
        }
    }
}
