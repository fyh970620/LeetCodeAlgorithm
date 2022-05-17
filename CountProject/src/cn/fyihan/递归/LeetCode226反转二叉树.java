package cn.fyihan.递归;

import sun.reflect.generics.tree.Tree;

public class LeetCode226反转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode treeNodeLeft = invertTree(root.left);
        TreeNode treeNoderight = invertTree(root.right);
        root.left = treeNoderight;
        root.right = treeNodeLeft;
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
