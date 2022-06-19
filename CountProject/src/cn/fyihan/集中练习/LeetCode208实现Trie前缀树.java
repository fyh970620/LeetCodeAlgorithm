package com.lagou.exam;

public class LeetCode208实现Trie前缀树 {

    private LeetCode208实现Trie前缀树[] tree;

    private boolean isExistHere;

    public LeetCode208实现Trie前缀树() {
        tree = new LeetCode208实现Trie前缀树[26];
        isExistHere = false;
    }

    public void insert(String word) {
        LeetCode208实现Trie前缀树 node = this;
        char[] simpleWords = word.toCharArray();
        for (int i=0; i<simpleWords.length; i++) {
            int index = simpleWords[i] - 'a';
            if (node.tree[index] == null) {
                node.tree[index] = new LeetCode208实现Trie前缀树();
            }
            node = node.tree[index];
        }
        node.isExistHere = true;
    }

    public boolean search(String word) {
        LeetCode208实现Trie前缀树 node = this;
        char[] simpleWords = word.toCharArray();
        for (int i=0; i<simpleWords.length; i++) {
            int index = simpleWords[i] - 'a';
            if (node.tree[index] == null) {
                return false;
            }
            node = node.tree[index];
            if (i == simpleWords.length - 1) {
                // 最后一层
                return node.isExistHere;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        LeetCode208实现Trie前缀树 node = this;
        char[] simpleWords = prefix.toCharArray();
        for (int i=0; i<simpleWords.length; i++) {
            int index = simpleWords[i] - 'a';
            if (node.tree[index] == null) {
                return false;
            }
            node = node.tree[index];
        }
        return true;
    }
}
