package cn.fyihan.BFS广搜;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dept = 1;
        while (!queue.isEmpty()) {
            int commonDeptSize = queue.size();
            for (int i = 0; i < commonDeptSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.right == null && node.left == null) {
                    return dept;
                }
            }
            dept++;
        }
        return dept;
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
