package com.sample.recursion;

/**
 * TODO: Describe purpose and behavior of WordSearch
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] input = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SFCCESEEDA";
        boolean result = wordSearch(input, word);
        System.out.println(result);
    }

    private static boolean wordSearch(char[][] input, String word) {
        for (int cnt = 0; cnt < input.length; cnt++) {
            for (int icnt = 0; icnt < input[0].length; icnt++) {
                if (input[cnt][icnt] == word.charAt(0)) {
                    return wordsearch(input, cnt, icnt, word, 0);
                }
            }
        }
        return false;
    }

    private static boolean wordsearch(char[][] input, int r, int c, String word, int start) {
        if (start >= word.length()) {
            return true;
        }
        if (r < 0 || r > input.length - 1 || c < 0 || c > input[0].length - 1) {
            return false;
        }

        if (input[r][c] == word.charAt(start)) {
            char temp = input[r][c];
            input[r][c] = '#';
            boolean result = wordsearch(input, r + 1, c, word, start + 1)
                    || wordsearch(input, r - 1, c, word, start + 1) || wordsearch(input, r, c + 1, word, start + 1)
                    || wordsearch(input, r, c - 1, word, start + 1);

            input[r][c] = temp;
            return result;
        }
        return false;
    }
}
