package com.sample.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of WordSearchTrie
 */
public class WordSearchTrie {

    class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }

    private static TrieNode root;

    public WordSearchTrie() {
        this.root = new TrieNode();
    }

    private void addWord(String word) {
        TrieNode p = root;
        for (int cnt = 0; cnt < word.length(); cnt++) {
            if (p.children[word.charAt(cnt) - 'a'] != null) {
                p = p.children[word.charAt(cnt) - 'a'];
            } else {
                p.children[word.charAt(cnt) - 'a'] = new TrieNode();
                p = p.children[word.charAt(cnt) - 'a'];
            }
        }
        p.leaf = true;
    }

    public static void main(String[] args) {
        WordSearchTrie trie = new WordSearchTrie();
        String[] inputs = { "oath", "pea", "eat", "rain" };
        for (String input : inputs) {
            trie.addWord(input);
        }
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        List<String> result = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                search(board, r, c, result, root, "");
            }
        }
        System.out.println(result.toString());
    }

    private static void search(char[][] board, int r, int c, List<String> result, TrieNode p, String curr) {
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1)
            return;

        char ch = board[r][c];
        curr = curr.concat(Character.toString(ch));
        if (ch - 'a' < 0)
            return;
        p = p.children[ch - 'a'];

        if (p == null)
            return;

        if (p.leaf) {
            result.add(curr);
            return;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        search(board, r + 1, c, result, p, curr);
        search(board, r - 1, c, result, p, curr);
        search(board, r, c + 1, result, p, curr);
        search(board, r, c - 1, result, p, curr);
        board[r][c] = temp;
    }
}
