package com.lagou.exam;

public class LeetCode11盛最多水的容器 {
    public int maxArea(int[] height) {
        // int sum = 最小的高度 * x轴的距离
        // 移动较高的边界指针，x轴变小，如果新的高度更低，sum更低。如果仍然大于上一轮最小高度，依然是递减状态，所以应该移动较低的边界指针
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int sum = 0;
        while (leftIndex < rightIndex) {
            int minIdex = Math.min(height[leftIndex], height[rightIndex]);
            sum = Math.max(minIdex * (rightIndex - leftIndex), sum);
            // 移动指针
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return sum;
    }
}
