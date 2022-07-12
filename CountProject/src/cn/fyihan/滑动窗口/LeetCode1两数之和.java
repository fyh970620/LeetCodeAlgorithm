package com.lagou.exam;

public class LeetCode1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] rtRes = new int[2];
        // 排序
        // Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int end = i + 1;
            while (end < nums.length) {
                if (nums[i] + nums[end] == target) {
                    // 因为是升序，所以必定不可能不重复情况下还能等于target
                    rtRes[0] = i;
                    rtRes[1] = end;
                    return rtRes;
                }
                end++;
            }
        }
        return rtRes;
    }
}
