package com.sample;

import java.io.IOException;

/**
 * TODO: Describe purpose and behavior of Test
 */
public class Test {

    public static void main(String[] args) throws IOException {
        numberToWord(1234567);
    }

    public static void numberToWord(int number) {

        if (number / 1000000 >= 1) {
            printOneToNine((int) number / 1000000);
            System.out.print(" million ");
            number %= 1000000;
        }
        if (number / 100000 >= 1) {
            printOneToNine((int) number / 100000);
            System.out.print(" hundred thousand ");
            number %= 100000;
        }
        if (number / 1000 >= 1) {
            printOneToNine((int) number / 1000);
            System.out.print(" thousand ");
            number %= 1000;
        }
        if (number / 100 >= 1) {
            printOneToNine((int) number / 100);
            System.out.print(" hundred ");
            number %= 100;
        }
    }

    public static void printOneToNine(int number) {
        switch (number) {
        case 1:
            System.out.print(" one ");
            break;
        case 2:
            System.out.print(" two ");
            break;
        case 3:
            System.out.print(" three ");
            break;
        case 4:
            System.out.print(" four ");
            break;
        case 5:
            System.out.print(" five ");
            break;
        case 6:
            System.out.print(" six ");
            break;
        case 7:
            System.out.print(" seven ");
            break;
        case 8:
            System.out.print(" eight ");
            break;
        case 9:
            System.out.print(" nine ");
            break;
        }
    }
}
