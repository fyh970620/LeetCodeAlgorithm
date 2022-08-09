package com.lagou.exam;

public class LeetCode98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return parseTreeNode(root, null, null);
    }

    private boolean parseTreeNode(TreeNode node, Integer lower, Integer hight) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) return false;
        if (hight != null && node.val >= hight) return false;

        boolean res1 = parseTreeNode(node.left, lower, node.val);
        boolean res2 = parseTreeNode(node.right, node.val, hight);
        return res1 && res2;
    }

    public class TreeNode {
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
