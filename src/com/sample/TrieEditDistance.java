package com.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TrieEditDistance
 */
public class TrieEditDistance {

    class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public TrieEditDistance() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;

        TrieNode p = this.root;
        for (int cnt = 0; cnt < word.length(); cnt++) {
            char ch = word.charAt(cnt);
            if (p.children[ch - 'a'] == null) {
                p.children[ch - 'a'] = new TrieNode();
            }
            p = p.children[ch - 'a'];
        }
        p.leaf = true;
    }

    public void printTree() {
        printHelper("", this.root);
    }

    private void printHelper(String curr, TrieNode p) {
        if (p.leaf) {
            System.out.println(curr);
        }
        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] != null) {
                printHelper(curr + (char) (cnt + 'a'), p.children[cnt]);
            }
        }
    }

    public boolean searchWord(String word) {
        if (word == null || word.isEmpty())
            return false;

        TrieNode p = this.root;
        for (int cnt = 0; cnt < word.length(); cnt++) {
            char ch = word.charAt(cnt);
            if (p.children[ch - 'a'] != null) {
                p = p.children[ch - 'a'];
            }
        }
        if (p.leaf)
            return true;
        else
            return false;
    }

    public boolean startsWith(String word) {
        if (word == null || word.isEmpty())
            return false;

        TrieNode p = this.root;
        for (int cnt = 0; cnt < word.length(); cnt++) {
            char ch = word.charAt(cnt);
            if (p.children[ch - 'a'] != null) {
                p = p.children[ch - 'a'];
            }
        }
        if (p != null)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        String[] input = { "abc", "abd", "abcd", "adc" };
        TrieEditDistance trie = new TrieEditDistance();
        for (int cnt = 0; cnt < input.length; cnt++) {
            trie.addWord(input[cnt].toLowerCase());
        }
        System.out.println(trie.searchWord("ninad"));
        System.out.println(trie.searchWord("abcd"));
        System.out.println(trie.startsWith("a"));
        trie.printTree();
        System.out.println(trie.searchWord("abcd"));
        trie.printKEditDistanceNodes("ac", 1);
        //trie.printKEditDistanceBFS("ac", 1);
    }

    private void printKEditDistanceNodes(String target, int k) {
        if (target == null || target.isEmpty() || k <= 0)
            return;

        List<String> result = new ArrayList<>();
        int[] currdistance = new int[target.length() + 1];
        for (int i = 0; i < currdistance.length; i++) {
            currdistance[i] = i;
        }
        printKEditDistanceHelper(result, "", target, k, currdistance, root);
        System.out.println("**" + result.toString());
    }

    private void printKEditDistanceHelper(List<String> result, String current, String target, int k,
            int[] prevdistance, TrieNode p) {
        if (p.leaf) {
            if (prevdistance[target.length()] <= k) {
                result.add(current);
            } else {
                return;
            }
        }

        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] == null) {
                continue;
            }
            int[] currdistance = new int[target.length() + 1];
            currdistance[0] = current.length() + 1;
            for (int i = 1; i < currdistance.length; i++) {
                if (target.charAt(i - 1) == (char) (cnt + 'a')) {
                    currdistance[i] = prevdistance[i - 1];
                } else {
                    currdistance[i] = Math.min(prevdistance[i - 1], Math.min(prevdistance[i], currdistance[i - 1])) + 1;
                }
            }
            printKEditDistanceHelper(result, current + (char) (cnt + 'a'), target, k, currdistance, p.children[cnt]);
        }

    }
}
