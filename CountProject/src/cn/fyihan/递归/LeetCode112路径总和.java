package cn.fyihan.递归;

public class LeetCode112路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum = targetSum - root.val;
        // 该路线走到尽头
        if (root.right == null && root.left == null) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
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
