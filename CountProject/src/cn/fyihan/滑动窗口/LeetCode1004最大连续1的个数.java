package cn.fyihan.滑动窗口;

public class LeetCode1004最大连续1的个数 {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int maxNum = Integer.MIN_VALUE;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroCount ++;
            }
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount --;
                }
                start ++;
            }
            maxNum = Math.max(maxNum, end - start +1);
            end ++;
        }
        return maxNum == Integer.MIN_VALUE? 0: maxNum;
    }
}
