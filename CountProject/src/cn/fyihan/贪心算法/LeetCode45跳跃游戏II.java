package com.lagou.exam;

import java.util.HashMap;
import java.util.Map;

public class LeetCode45跳跃游戏II {
    private Map<Integer, Integer> jumpSteps = new HashMap<>();

    private Integer minSteps = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int firstStep = nums[0];
        if (firstStep == 0) {
            return -1;
        }
        for (int i = 1; i <= firstStep; i++) {
            int sumSteps = jumpDetail(nums, 1, i);
            if (sumSteps != -1) {
                minSteps = Math.min(sumSteps, minSteps);
            }
        }
        return minSteps;
    }

    private int jumpDetail(int[] nums, int jumpCount, int nextIdex) {
        if (nextIdex >= nums.length - 1) {
            return jumpCount;
        }
        if (jumpSteps.containsKey(nextIdex)) {
            return jumpCount + jumpSteps.get(nextIdex);
        }
        int currSteps = nums[nextIdex];
        if (currSteps == 0) {
            return -1;
        }
        int currMinSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= currSteps; i++) {
            int stepCount = jumpDetail(nums, jumpCount + 1, nextIdex + i);
            if (stepCount != -1) {
                currMinSteps = Math.min(currMinSteps, stepCount - jumpCount);
            }
        }
        if (currMinSteps == Integer.MAX_VALUE) {
            return -1;
        }
        jumpSteps.put(nextIdex, currMinSteps);
        return currMinSteps + jumpCount;
    }

    public static void main(String[] args) {
        LeetCode45跳跃游戏II test = new LeetCode45跳跃游戏II();
        test.jump(new int[]{2, 3, 1, 1, 4});
    }
}
