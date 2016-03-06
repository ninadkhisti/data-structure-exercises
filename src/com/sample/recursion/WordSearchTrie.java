package com.sample.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: Describe purpose and behavior of WordSearchTrie
 */
public class WordSearchTrie {

    class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public WordSearchTrie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;
        TrieNode p = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (p.children[word.charAt(i) - 'a'] == null) {
                p.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            p = p.children[word.charAt(i) - 'a'];
        }
        p.leaf = true;
    }

    public void printTrie() {
        StringBuffer sb = new StringBuffer();
        print(this.root, sb);
    }

    private void print(TrieNode p, StringBuffer sb) {
        if (p.leaf) {
            System.out.println(sb.toString());
            //return; * imp
        }
        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] != null) {
                print(p.children[cnt], sb.append((char) (cnt + 'a')));
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        WordSearchTrie trie = new WordSearchTrie();
        //String[] inputs = { "oath", "pea", "eat", "rain" };
        String[] inputs = { "ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb" };
        for (String input : inputs) {
            trie.addWord(input);
        }
        trie.printTrie();
        //char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
        //      { 'i', 'f', 'l', 'v' } };
        char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
        List<String> result = trie.wordFinder(board);
        System.out.println(result.toString());
    }

    private List<String> wordFinder(char[][] board) {
        Set<String> result = new HashSet<>();
        if (board == null || board.length == 0)
            return Collections.emptyList();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuffer sb = new StringBuffer();
                boggler(board, i, j, result, this.root, sb);
            }
        }
        return new ArrayList<>(result);
    }

    private void boggler(char[][] board, int i, int j, Set<String> result, TrieNode p, StringBuffer sb) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return;
        }
        char ch = board[i][j];
        if (ch == '#') {
            return;
        }
        p = p.children[ch - 'a'];
        if (p == null) {
            return;
        }
        sb.append(ch);
        if (p.leaf) {
            result.add(sb.toString());
            //return; * imp
        }

        board[i][j] = '#';

        boggler(board, i + 1, j, result, p, sb);
        boggler(board, i - 1, j, result, p, sb);
        boggler(board, i, j - 1, result, p, sb);
        boggler(board, i, j + 1, result, p, sb);
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = ch;
    }

}
