package com.lagou.exam;

public class LeetCode1909删除一个元素使数组严格递增 {
    public boolean canBeIncreasing(int[] nums) {
        if (nums.length == 3) {
            return specialTrend(nums);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] - nums[i - 1]) * (nums[i + 1] - nums[i]) <= 0) {
                boolean trend1 = checkTrend(i - 1, nums);
                boolean trend2 = checkTrend(i, nums);
                boolean trend3 = checkTrend(i + 1, nums);
                if (trend1 || trend2 || trend3) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean specialTrend(int[] nums) {
        if (nums.length == 3) {
            if (nums[1] - nums[0] > 0 || nums[2] - nums[1] > 0 || nums[2] - nums[0] > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTrend(int delIdex, int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == delIdex || (i - 1 == delIdex && i - 1 == 0)
                    || (i + 1 == delIdex && i + 1 == nums.length - 1)) {
                continue;
            }
            int lastIdex = i - 1 == delIdex ? i - 2 : i - 1;
            int nextIdex = i + 1 == delIdex ? i + 2 : i + 1;
            if ((nums[nextIdex] - nums[i]) * (nums[i] - nums[lastIdex]) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1909删除一个元素使数组严格递增 test = new LeetCode1909删除一个元素使数组严格递增();
        test.canBeIncreasing(new int[]{1,1,1});
    }
}
