package cn.fyihan.二叉树;

public class LeetCode124二叉树中的最大路径和 {
    private Integer maxNum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        countTreeNode(root);
        return maxNum == Integer.MIN_VALUE ? 0 : maxNum;
    }

    private int countTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 值小于0则认为是没有任何路径贡献
        int leftValue = Math.max(0, countTreeNode(root.left));
        int rightValue = Math.max(0, countTreeNode(root.right));
        maxNum = Math.max(leftValue + rightValue + root.val, maxNum);
        // 能作为上面的路径的，左右节点只能二选一
        return Math.max(leftValue, rightValue) + root.val;
    }

    public static void main(String[] args) {
        LeetCode124二叉树中的最大路径和 test = new LeetCode124二叉树中的最大路径和();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20));
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.maxPathSum(root));
    }

    public static class TreeNode {
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


