package cn.fyihan.前缀和哈希表优化;

import java.util.HashMap;
import java.util.Map;

public class LeetCode523连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
         int prefixNum = 0;
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         map.put(0, -1);
         int prefixSun = 0;
         // 余数
         int remainder = 0;
        for (int i=0; i<nums.length; i++) {
             prefixSun += nums[i];  // 前缀和
             remainder = prefixSun % k;
             if (map.containsKey(remainder)) {
                 if ( i- map.get(remainder) >= 2) {
                     return true;
                 }
             }else {
                map.put(remainder, i);
             }
         }
        return false;
    }
}
