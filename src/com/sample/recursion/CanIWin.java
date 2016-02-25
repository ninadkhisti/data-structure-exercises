package com.sample.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of CanIWin
 */
public class CanIWin {

    public static void main(String[] args) {
        System.out.println(canIWin(4, 11));
    }

    private static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || desiredTotal <= 0)
            return false;

        List<Integer> choices = new ArrayList<>();
        for (int i = 1; i < maxChoosableInteger; i++) {
            choices.add(i);
        }

        return canIWinhelper(desiredTotal, choices);
    }

    private static boolean canIWinhelper(int desiredTotal, List<Integer> choices) {
        if (choices.get(choices.size() - 1) >= desiredTotal) {
            return true;
        }
        for (int i = 0; i < choices.size(); i++) {
            int removed = choices.remove(i);
            boolean win = !canIWinhelper(desiredTotal - removed, choices);
            choices.add(i, removed);
            if (win) {
                return true;
            }
        }

        return false;
    }
}
