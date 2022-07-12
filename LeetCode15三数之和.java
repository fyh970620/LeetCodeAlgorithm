package com.lagou.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtRes = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < 3) {
            return rtRes;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int targetNum = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            if (i >= 1 && start < end && nums[i] == nums[start] && nums[i - 1] == nums[i]) {
                continue;
            }
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum + targetNum > 0) {
                    end--;
                    continue;
                }
                if (sum + targetNum < 0) {
                    start++;
                    continue;
                }
                if (sum + targetNum == 0) {
                    // [0,0,0,0]的情况下输出[0,0,0] [0,0,0]的情况
                    rtRes.add(Arrays.asList(nums[start], nums[end], nums[i]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
        }
        return rtRes;
    }

    public static void main(String[] args) {
        LeetCode15三数之和 test = new LeetCode15三数之和();
        // test.threeSum(new int[]{-1,0,1,2,-1,-4});
        test.threeSum(new int[]{0, 0, 0, 0});
    }
}
