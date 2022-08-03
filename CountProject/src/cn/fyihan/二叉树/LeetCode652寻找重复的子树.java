package com.lagou.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode652寻找重复的子树 {
    private Map<String, Integer> repeatTreeMap = new HashMap<>();

    private List<TreeNode> nodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        praseTreeNode(root);
        return nodes;
    }

    private String praseTreeNode(TreeNode node) {
        if (node == null) {
            return "";
        }
        // 中序的方式
        String parseKey = node.val + "-" + praseTreeNode(node.left)  + "-" + praseTreeNode(node.right);
        int count = repeatTreeMap.getOrDefault(parseKey, 0) + 1;
        repeatTreeMap.put(parseKey, count);
        if (count == 2) {
            nodes.add(node);
        }
        return parseKey;
    }

    public static void main(String[] args) {
        LeetCode652寻找重复的子树 test = new LeetCode652寻找重复的子树();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.right = new TreeNode(0);
        test.findDuplicateSubtrees(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

