package com.sample.array;

/**
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.htmls
 */
public class MajorityElement {

    public static void main(String[] args) {

        char[] array = { 'a', 'a', 'a', 'c', 'c', 'b', 'b', 'c', 'c', 'c', 'b', 'c', 'c' };

        int counter = 1;
        char majority = array[0];

        for (int cnt = 1; cnt < array.length; cnt++) {
            if (array[cnt] == majority) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                majority = array[cnt];
            }
        }
        System.out.println("majority =>" + majority + " count =>" + counter);
    }
}
