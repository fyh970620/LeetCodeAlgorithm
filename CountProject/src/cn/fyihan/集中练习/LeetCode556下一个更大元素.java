package com.lagou.exam;

import java.util.Arrays;

public class LeetCode556下一个更大元素 {
    public int nextGreaterElement(int n) {
        char[] nums = (n + "").toCharArray();
        if (nums.length == 1) {
            return -1;
        }
        int length = nums.length;
        int idex = -1;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                char temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                idex = i;
                break;
            }
        }
        if (idex == -1) {
            return -1;
        }
        for (int i = idex + 1; i < length; i++) {
            if (nums[i] > nums[idex] && nums[i] < nums[idex - 1]) {
                char temp = nums[idex - 1];
                nums[idex - 1] = nums[i];
                nums[i] = temp;
            }
        }
        Arrays.sort(nums, idex, length);
        long ans = Long.parseLong(String.valueOf(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public static void main(String[] args) {
        LeetCode556下一个更大元素 test = new LeetCode556下一个更大元素();
        // 测试用例一
        // test.nextGreaterElement(12);
        // 测试用例二
        test.nextGreaterElement(21);
        // 自测
        test.nextGreaterElement(2147483476);
    }
}
