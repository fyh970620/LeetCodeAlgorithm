package cn.fyihan.前缀和哈希表优化;

public class LeetCode560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] prefixArrray = new int[nums.length+1];
        prefixArrray[0] = 0;
        for (int i = 0; i<length; i++) {
            prefixArrray[i+1] = prefixArrray[i] + nums[i];
        }
        int count = 0;
        for (int i=0; i<length; i++) {
            for (int j=i; j<length; j++) {
                if (prefixArrray[j+1] - prefixArrray[i] == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}
