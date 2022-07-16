package com.lagou.exam;


import java.util.*;

public class LeetCode102二叉树的层序遍历 {
    public static void main(String[] args) {
        LeetCode102二叉树的层序遍历 test = new LeetCode102二叉树的层序遍历();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
    }
    private Map<Integer, List<Integer>> deptMap = new HashMap<>();

    private Integer maxDept = Integer.MIN_VALUE;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        deptMap.put(0, Arrays.asList(root.val));
        maxDept = 0;
        // 左
        parseDeptNode(root.left, 1);
        // 右
        parseDeptNode(root.right, 1);
        List<List<Integer>> rtRes = new ArrayList<>();
        for (int i = 0; i <= maxDept; i++) {
            rtRes.add(deptMap.get(i));
        }
        return rtRes;
    }

    private void parseDeptNode(TreeNode node, int dept) {
        if (node == null) {
            return;
        }
        List<Integer> deptDatas = deptMap.getOrDefault(dept, new ArrayList<>());
        deptDatas.add(node.val);
        deptMap.put(dept, deptDatas);
        maxDept = Math.max(maxDept, dept);
        // 左
        parseDeptNode(node.left, dept + 1);
        // 右
        parseDeptNode(node.right, dept + 1);
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
