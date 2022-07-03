package com.lagou.exam;

import java.util.*;

public class LeetCode199二叉树的右视图 {
    private Map<Integer, List<Integer>> deptMap = new HashMap<>();

    private int maxDept = -1;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        injectDatas(root, 0);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= maxDept; i++) {
            res.add(deptMap.get(i).get(0));
        }
        return res;
    }

    private void injectDatas(TreeNode node, int dept) {
        List<Integer> datas = deptMap.getOrDefault(dept, new ArrayList<>());
        maxDept = Math.max(maxDept, dept);
        datas.add(node.val);
        deptMap.put(dept, datas);
        if (node.right != null) {
            injectDatas(node.right, dept + 1);
        }
        if (node.left != null) {
            injectDatas(node.left, dept + 1);
        }
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

    public static void main(String[] args) {
        // 测试用例1
        LeetCode199二叉树的右视图 test = new LeetCode199二叉树的右视图();
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        node.left.right =  new TreeNode(5);
        node.right.right =  new TreeNode(4);
        System.out.println(test.rightSideView(node));
        // 测试用例二
        /*TreeNode node = new TreeNode(1, null, new TreeNode(3));
        System.out.println(test.rightSideView(node));*/
        // 测试用例三
        // System.out.println(test.rightSideView(null));
        // 自测用例
        /*TreeNode node = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(5);
        node.left.left.right = new TreeNode(2);
        // node.left.left = new TreeNode(6);
        // node.right.right =  new TreeNode(4);
        // node.right.left =  new TreeNode(7);
        System.out.println(test.rightSideView(node));*/
    }
}
