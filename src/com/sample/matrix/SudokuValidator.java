package com.sample.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of SudokuValidator
 */
public class SudokuValidator {

    public static void main(String[] args) {
        char[][] sudoku = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        boolean result = validateSudoku(sudoku);
        // SudokuSolver challenge
        System.out.println(result);
    }

    private static boolean validateSudoku(char[][] sudoku) {
        int r = sudoku.length - 1;

        for (int i = 0; i <= r; i++) {
            if (!validate(0, i, 8, i, sudoku))
                return false;
            if (!validate(i, 0, i, 8, sudoku))
                return false;
        }

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (!validate(i * 3, j * 3, i * 3 + 2, j * 3 + 2, sudoku))
                    return false;
            }
        }

        return true;
    }

    private static boolean validate(int r1, int c1, int r2, int c2, char[][] sudoku) {
        Set<Character> set = new HashSet<>();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (sudoku[i][j] != '.' && !set.add(sudoku[i][j]))
                    return false;
            }
        }
        return true;
    }
}
