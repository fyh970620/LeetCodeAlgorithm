package cn.fyihan.exam.LeetCodeTest;

public class LeetCode211添加与搜索单词数据结构设计 {
    private Node root;

    public LeetCode211添加与搜索单词数据结构设计() {
        root = new Node();
    }

    public void addWord(String word) {
        Node tempNode = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (tempNode.nodes[index] == null) {
                tempNode.nodes[index] = new Node();
            }
            tempNode = tempNode.nodes[index];
        }
        tempNode.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, Node node, int charIndex) {
        if (charIndex == word.length()) {
            return node.isEnd;
        }
        char targetChar = word.charAt(charIndex);
        if (targetChar == '.') {
            for (int i=0; i < 26; i++) {
                if (node.nodes[i] != null && dfs(word, node.nodes[i], charIndex + 1)) {
                    return true;
                }
            }
        } else {
            int index = word.charAt(charIndex) - 'a';
            if (node.nodes[index] != null) {
                return dfs(word, node.nodes[index], charIndex + 1);
            } else {
                return false;
            }
        }
        return false;
    }

    public class Node {
        // 包含的26个字母
        Node[] nodes;
        // 是否已经结束
        boolean isEnd;

        public Node(){
            nodes = new Node[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        LeetCode211添加与搜索单词数据结构设计 test = new LeetCode211添加与搜索单词数据结构设计();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        test.search("bad");
        test.search(".ad");
        test.search("b..");
    }
}
