package cn.fyihan.¶þ²æÊ÷;

import sun.reflect.generics.tree.Tree;

public class LeetCode814¶þ²æÊ÷¼ôÖ¦ {
    public TreeNode pruneTree(TreeNode root) {
        if (isTailoring(root)) {
            root = null;
        }
        return root;
    }

    private Boolean isTailoring(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean lres = isTailoring(node.left);
        if (lres) {
            node.left = null;
        }
        boolean rres = isTailoring(node.right);
        if (rres) {
            node.right = null;
        }
        if (node.val == 0 && (lres && rres)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(1, null, new TreeNode(0));
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right= new TreeNode(1);
        LeetCode814¶þ²æÊ÷¼ôÖ¦ test = new LeetCode814¶þ²æÊ÷¼ôÖ¦();
        test.pruneTree(treeNode);*/
        // È«²¿Îª1
        /*TreeNode treeNode = new TreeNode(1, null, new TreeNode(1));
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right= new TreeNode(1);
        LeetCode814¶þ²æÊ÷¼ôÖ¦ test = new LeetCode814¶þ²æÊ÷¼ôÖ¦();
        test.pruneTree(treeNode);*/
        // È«²¿Îª0
        TreeNode treeNode = new TreeNode(0, null, new TreeNode(0));
        LeetCode814¶þ²æÊ÷¼ôÖ¦ test = new LeetCode814¶þ²æÊ÷¼ôÖ¦();
        test.pruneTree(treeNode);
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
