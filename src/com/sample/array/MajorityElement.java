package com.sample.array;

/**
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
 */
public class MajorityElement {

    public static void main(String[] args) {

        //char[] array = { 'a', 'a', 'a', 'z', 'c', 'c', 'b', 'b', 'i', 'j', 'c', 'c', 'c', 'b', 'c', 'c', 'd', 'e', 'f',
        //      'g' };

        char[] array = { 'a', 'b', 'b', 'c' };

        int counter = 1;
        char majority = array[0];

        for (int cnt = 1; cnt < array.length; cnt++) {
            if (counter == 0) {
                majority = array[cnt];
                counter = 1;
            } else if (array[cnt] == majority) {
                counter++;
            } else {
                counter--;
            }

        }
        System.out.println("majority =>" + majority + " count =>" + counter);
        majorityElements(array);
    }

    public static void majorityElements(char[] array) {
        int counter1 = 0, counter2 = 0;
        char majority1 = 0, majority2 = 0;

        for (int cnt = 0; cnt < array.length; cnt++) {
            if (counter1 == 0) {
                majority1 = array[cnt];
                counter1++;
            } else if (counter2 == 0) {
                majority2 = array[cnt];
                counter2++;
            } else if (majority1 == array[cnt]) {
                counter1++;
            } else if (majority2 == array[cnt]) {
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        System.out.println("Majority 1=> " + majority1 + " count=> " + counter1);
        System.out.println("Majority 2=> " + majority2 + " count=> " + counter2);

    }
}
