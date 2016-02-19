package com.sample.string;

/**
 * TODO: Describe purpose and behavior of FactorialZeros
 */
public class FactorialZeros {

    public static void main(String[] args) {
        int zeros = 0;
        int n = 50;
        for (int cnt = 5; cnt <= n; cnt = cnt * 5) {
            zeros += (int) n / cnt;
        }
        System.out.println(zeros);
    }
}
