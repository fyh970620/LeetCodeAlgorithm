package com.lagou.exam;

import java.util.*;

public class LeetCode俯视二叉树 {
    private TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();

    private List<Integer> targetList = new ArrayList<>();

    public List<Integer> lookDownTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, Integer> deptMap = new TreeMap<>();
        deptMap.put(0, root.val);
        map.put(0, deptMap);
        injectTreeDatas(root, 0, 0);
        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : map.entrySet()) {
            TreeMap<Integer, Integer> tempDeptMaps = entry.getValue();
            if (tempDeptMaps.size() > 0) {
                Object[] targetNum = tempDeptMaps.values().toArray();
                targetList.add(Integer.parseInt(targetNum[0] + ""));
            }
        }
        return targetList;
    }

    private void injectTreeDatas(TreeNode root, int index, int dept) {
        if (root.left != null) {
            TreeMap<Integer, Integer> deptMap = map.getOrDefault(index - 1, new TreeMap<>());
            deptMap.put(dept, root.left.val);
            map.put(index - 1, deptMap);
            injectTreeDatas(root.left, index - 1, dept + 1);
        }
        if (root.right != null) {
            TreeMap<Integer, Integer> deptMap = map.getOrDefault(index + 1, new TreeMap<>());
            deptMap.put(dept, root.right.val);
            map.put(index + 1, deptMap);
            injectTreeDatas(root.right, index + 1, dept + 1);
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
        LeetCode俯视二叉树 test = new LeetCode俯视二叉树();
        /*TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        node.left.right =  new TreeNode(5);
        node.right.right =  new TreeNode(4);
        System.out.println(test.lookDownTree(node));*/
        // 测试用例二
        /*TreeNode node = new TreeNode(1, null, new TreeNode(3));
        System.out.println(test.lookDownTree(node));*/
        // 测试用例三
        /*System.out.println(test.lookDownTree(null));*/
        // 自测用例
        TreeNode node = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(5);
        node.left.left.right = new TreeNode(2);
        // node.left.left = new TreeNode(6);
        // node.right.right =  new TreeNode(4);
        // node.right.left =  new TreeNode(7);
        System.out.println(test.lookDownTree(node));
    }
}
