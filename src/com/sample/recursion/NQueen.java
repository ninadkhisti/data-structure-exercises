package com.sample.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of NQueen
 */
public class NQueen {

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<List<String>>();
        result = solveNQueens(8);
        for (List<String> board : result) {
            System.out.print("[");
            for (String row : board) {
                System.out.println(row + ",");
            }
            System.out.print("]");
        }
        System.out.println(result.size());
    }

    private static List<List<String>> solveNQueens(int n) {
        if (n <= 0)
            return Collections.emptyList();
        List<List<String>> result = new ArrayList<>();
        boolean[] ld = new boolean[2 * n];
        boolean[] rd = new boolean[2 * n];
        boolean[] column = new boolean[n];
        List<String> board = new ArrayList<>();
        placeNQueens(result, board, ld, rd, column, 0, n);
        return result;
    }

    private static void placeNQueens(List<List<String>> result, List<String> board, boolean[] ld, boolean[] rd,
            boolean[] column, int row, int n) {
        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int leftdiag = row + col;
            int rightdiag = row - col + n;
            if (!column[col] && !ld[leftdiag] && !rd[rightdiag]) {
                column[col] = true;
                ld[leftdiag] = true;
                rd[rightdiag] = true;
                char[] arow = new char[n];
                Arrays.fill(arow, '.');
                arow[col] = 'Q';
                board.add(new String(arow));
                placeNQueens(result, board, ld, rd, column, row + 1, n);
                board.remove(board.size() - 1);
                column[col] = false;
                ld[leftdiag] = false;
                rd[rightdiag] = false;
            }
        }

    }
}
