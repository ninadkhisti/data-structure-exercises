package com.sample.recursion;

/**
 * TODO: Describe purpose and behavior of AddSearchWord
 */
public class AddSearchWord {

    class TrieNode {
        boolean leaf;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public AddSearchWord() {
        this.root = new TrieNode();
    }

    public static void main(String[] args) {
        AddSearchWord api = new AddSearchWord();
        api.addWord("at");
        api.addWord("and");
        api.addWord("an");
        api.addWord("add");
        api.search("a");
        api.search(".at");
        api.addWord("bat");
        api.print();
        System.out.println(api.search(".at"));
        api.search("an.");
        api.search("a.d.");
        api.search("b.");
        api.search("a.d");
        api.search(".");

    }

    public void addWord(String word) {
        TrieNode p = root;
        for (int cnt = 0; cnt < word.length(); cnt++) {
            if (p.children[word.charAt(cnt) - 'a'] == null) {
                p.children[word.charAt(cnt) - 'a'] = new TrieNode();
            }
            p = p.children[word.charAt(cnt) - 'a'];
        }
        p.leaf = true;
    }

    public void print() {
        StringBuffer sb = new StringBuffer();
        printTrie(this.root, sb);
    }

    private void printTrie(TrieNode p, StringBuffer sb) {
        if (p.leaf) {
            System.out.println(sb.toString());
        }
        for (int cnt = 0; cnt < 26; cnt++) {
            if (p.children[cnt] != null) {
                printTrie(p.children[cnt], sb.append((char) (cnt + 'a')));
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public boolean search(String pattern) {
        boolean result = searchWord(pattern, root, 0);
        return result;
    }

    private boolean searchWord(String pattern, TrieNode p, int start) {
        if (start == pattern.length() && p.leaf) {
            return true;
        }
        if (start > pattern.length() - 1) {
            return false;
        }
        if (p == null)
            return false;

        char ch = pattern.charAt(start);

        if (ch == '.') {
            for (int cnt = 0; cnt < 26; cnt++) {
                if (p.children[cnt] != null) {
                    boolean result = searchWord(pattern, p.children[cnt], start + 1);
                    if (result) {
                        return true;
                    }
                }
            }
        } else {
            if (p.children[ch - 'a'] != null) {
                return searchWord(pattern, p.children[ch - 'a'], start + 1);
            }
        }

        return false;
    }

}
