package com.lagou.exam;

import java.util.ArrayList;
import java.util.List;

public class LeetCode173二叉搜索树迭代器 {

    private List<Integer> treeNums;

    private Integer iteratorIndex;

    public LeetCode173二叉搜索树迭代器(TreeNode root) {
        iteratorIndex = 0;
        treeNums = new ArrayList<>();
        injectTreeInArray(root, treeNums);
    }

    public int next() {
        if (iteratorIndex < treeNums.size()) {
            return treeNums.get(iteratorIndex++);
        }
        return 0;
    }

    public boolean hasNext() {
        return iteratorIndex < treeNums.size();
    }

    private void injectTreeInArray(TreeNode root, List<Integer> iteratorArr) {
        if (root == null) {
            return;
        }
        // 左子树
        injectTreeInArray(root.left, iteratorArr);
        // 为空后开始赋值
        iteratorArr.add(root.val);
        // 右子树
        injectTreeInArray(root.right, iteratorArr);
    }

     public class TreeNode {
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
