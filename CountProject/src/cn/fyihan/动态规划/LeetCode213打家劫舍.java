package com.lagou.exam;

public class LeetCode213打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 从第一位开始获取，则最后一位不能获取
        return Math.max(catchMax(nums, 0, nums.length - 2),
                catchMax(nums, 1, nums.length - 1));
    }

    public int catchMax(int[] nums, int start, int end) {
        int res1 = nums[start];
        // 相邻两个数中最大的值
        int res2 = Math.max(res1, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = res2;
            // 非相邻两个数求和 & 相邻两个数中最大值比较 看是获取一个还是两个的和
            res2 = Math.max(res1 + nums[i], res2);
            // res1前进一位
            res1 = temp;
        }
        return res2;
    }

    public static void main(String[] args) {
        // 自定义测试用例1
        LeetCode213打家劫舍 test = new LeetCode213打家劫舍();
        // System.out.println(test.rob(new int[]{1,4,5,9,10,20}));
        // 测试用例2 1,2,3,1 res:4
        // System.out.println(test.rob(new int[]{1,2,3,1}));
        // 测试用例3 1,2,3 res:3
        System.out.println(test.rob(new int[]{1, 2, 3}));
        // 测试用例
    }
}
