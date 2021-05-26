/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
// 节点类
// 每次new一个新节点具有26个子节点容纳26个字母
class TrieNode {
    public boolean isEndofWord;
    public TrieNode[] chilTrieNodes = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
    }
}

class Trie {
    private TrieNode rNode;

    /** Initialize your data structure here. */
    public Trie() {
        rNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        TrieNode curNode = rNode;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            int index = curChar - 'a';
            if (curNode.chilTrieNodes[index] == null) {
                curNode.chilTrieNodes[index] = new TrieNode(curChar);
            }
            curNode = curNode.chilTrieNodes[index];
        }

        curNode.isEndofWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        TrieNode curNode = rNode;
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (curNode.chilTrieNodes[index] == null) {
                return false;
            }
            curNode = curNode.chilTrieNodes[index];
        }
        return curNode.isEndofWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode curNode = rNode;
        for (int i = 0; i < len; i++) {
            int index = prefix.charAt(i) - 'a';
            if (curNode.chilTrieNodes[index] == null) {
                return false;
            }
            curNode = curNode.chilTrieNodes[index];
        }

        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
