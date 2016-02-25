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
        api.addWord("bad");
        api.addWord("mom");
        api.addWord("dad");
        api.addWord("mum");

        System.out.println(api.searchWord("dad"));
        System.out.println(api.searchWord("ninad"));
        System.out.println(api.searchWord("..d"));
        System.out.println(api.searchWord("m.."));

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

    public boolean searchWord(String pattern) {
        boolean result = searchWord(pattern, root, 0);
        return result;
    }

    private boolean searchWord(String pattern, TrieNode p, int start) {
        if (start == pattern.length() && p.leaf) {
            return true;
        }
        if (start > pattern.length()) {
            return false;
        }
        if (p == null)
            return false;

        char ch = pattern.charAt(start);
        if (ch == '.') {
            for (int cnt = 0; cnt < 26; cnt++) {
                if (p.children[cnt] != null) {
                    return searchWord(pattern, p.children[cnt], start + 1);
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
