package com.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO: Describe purpose and behavior of TrieEditDistance
 */
public class TrieEditDistance {

    private TrieNode root;

    public TrieEditDistance() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0)
            return;

        char[] wordChars = word.toCharArray();
        TrieNode p = root;
        for (int cnt = 0; cnt < wordChars.length; cnt++) {
            if (p.children[wordChars[cnt] - 'a'] != null) {
                p = p.children[wordChars[cnt] - 'a'];
            } else {
                p.children[wordChars[cnt] - 'a'] = new TrieNode();
                p = p.children[wordChars[cnt] - 'a'];
            }
        }
        p.leaf = true;
    }

    public boolean searchWord(String word) {
        if (word == null || word.length() == 0)
            return false;

        char[] wordChards = word.toCharArray();
        TrieNode p = root;
        for (int cnt = 0; cnt < wordChards.length; cnt++) {
            if (p.children[wordChards[cnt] - 'a'] != null) {
                p = p.children[wordChards[cnt] - 'a'];
            } else {
                return false;
            }
        }
        if (p.leaf) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String word) {
        if (word == null || word.length() == 0)
            return false;

        char[] wordChars = word.toCharArray();
        TrieNode p = root;

        for (int cnt = 0; cnt < wordChars.length; cnt++) {
            if (p.children[wordChars[cnt] - 'a'] != null)
                p = p.children[wordChars[cnt] - 'a'];
            else
                return false;
        }
        return true;
    }

    public void printTree() {
        printHelper(root, new StringBuffer());
    }

    public void printKEditDistanceBFS(String target, int k) {
        Queue<Node> queue = new LinkedList<>();
        for (int cnt = 0; cnt < 26; cnt++) {
            if (root.children[cnt] != null) {
                Node n = new Node(root.children[cnt]);
                if (target.charAt(0) != ((char) (cnt + 'a'))) {
                    n.k++;
                }
                n.current.append(((char) (cnt + 'a')));
                queue.add(n);
            }
        }

        int index = 1;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            TrieNode tnode = node.node;
            int ksofar = node.k;
            if (ksofar <= k && tnode.leaf) {
                System.out.println(node.current.toString());
            }
            for (int cnt = 0; cnt < 26; cnt++) {
                if (tnode.children[cnt] != null) {
                    if (target.charAt(index) != ((char) (cnt + 'a'))) {
                        ksofar++;
                    }
                    if (ksofar <= k) {
                        Node n1 = new Node(tnode.children[cnt]);
                        n1.k = ksofar;
                        n1.current = node.current.append((char) (cnt + 'a'));
                        queue.add(n1);
                    }
                }
            }
            //index++;
        }

    }

    public void printKEditDistanceNodes(String target, int k) {
        int[] prev = new int[target.length() + 1];
        for (int cnt = 0; cnt < target.length(); cnt++) {
            prev[cnt] = cnt;
        }
        List<String> result = new ArrayList<>();
        kEditDistanceHelper("", target, k, prev, root, result);
        System.out.println("***" + result.toString());
    }

    private void kEditDistanceHelper(String current, String target, int k, int[] prev, TrieNode p, List<String> result) {
        if (p.leaf) {
            if (prev[target.length()] <= k) {
                result.add(current);
            } else {
                return;
            }
        }

        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] == null) {
                continue;
            }

            int[] curr = new int[target.length() + 1];
            curr[0] = current.length() + 1;
            for (int icnt = 1; icnt < curr.length; icnt++) {
                if (target.charAt(icnt - 1) == (char) (cnt + 'a')) {
                    curr[icnt] = prev[icnt - 1];
                } else {
                    curr[icnt] = Math.min(Math.min(prev[icnt - 1], prev[icnt]), curr[icnt - 1]) + 1;
                }
            }
            kEditDistanceHelper(current + (char) (cnt + 'a'), target, k, curr, p.children[cnt], result);
        }
    }

    private void printHelper(TrieNode p, StringBuffer sb) {
        if (p == null)
            return;

        if (p.leaf) {
            System.out.println(sb.toString());
        }
        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] == null) {
                continue;
            }
            if (p.children[cnt] != null) {
                printHelper(p.children[cnt], sb.append((char) ('a' + cnt)));
                sb.deleteCharAt(sb.length() - 1);
            }

        }

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
        trie.printKEditDistanceBFS("ac", 1);
    }

    class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }

    class Node {
        int k;
        StringBuffer current;
        TrieNode node;

        public Node(TrieNode node) {
            k = 0;
            current = new StringBuffer();
            this.node = node;
        }
    }
}
