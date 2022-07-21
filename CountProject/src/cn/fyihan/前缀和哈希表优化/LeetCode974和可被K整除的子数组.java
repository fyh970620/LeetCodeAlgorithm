package cn.fyihan.前缀和哈希表优化;

import java.util.*;

public class LeetCode974和可被K整除的子数组 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> remainderMap = new HashMap<>();
        List<Integer> onwer = new ArrayList<>();
        onwer.add(-1);
        remainderMap.put(0, onwer);
        int[] remainerSum = new int[nums.length + 1];
        for (int i = 1; i < remainerSum.length; i++) {
            remainerSum[i] = remainerSum[i - 1] + nums[i - 1];
            int remain = remainerSum[i] % k;
            if (remain < 0) {
                remain = (remain + k) % k;
            }
            List<Integer> datas = remainderMap.getOrDefault(remain, new ArrayList<>());
            count += datas.size();
            datas.add(i);
            remainderMap.put(remain, datas);
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode974和可被K整除的子数组 test = new LeetCode974和可被K整除的子数组();
        test.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        test.subarraysDivByK(new int[]{5}, 9);
    }
}
