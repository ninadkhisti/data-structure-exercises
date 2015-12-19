package com.sample.binarytree;

/**
 * TODO: Describe purpose and behavior of Assert
 */
public class Assert {

    public static void main(String[] args) {
        int argCount = args.length;
        assert argCount == 5 : "The number of arguments must be 5";
        System.out.println("OK");
    }
}
