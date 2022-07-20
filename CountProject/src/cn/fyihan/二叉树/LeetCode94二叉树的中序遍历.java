package cn.fyihan.二叉树;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94二叉树的中序遍历 {
    private List<Integer> rtRes = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        midPraseNode(root);
        return rtRes;
    }

    private void midPraseNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midPraseNode(treeNode.left);
        rtRes.add(treeNode.val);
        midPraseNode(treeNode.right);
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
