package cn.fyihan.分治;

public class LeetCode169求众数 {
    public int majorityElement(int[] nums) {
        int targetNum = nums[0];
        int targetCount = 1;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] == targetNum) {
                targetCount++;
            } else {
                targetCount--;
            }
            if (targetCount == 0) {
                targetNum = nums[i];
                targetCount = 1;
            }
        }
        return targetNum;
    }
}
