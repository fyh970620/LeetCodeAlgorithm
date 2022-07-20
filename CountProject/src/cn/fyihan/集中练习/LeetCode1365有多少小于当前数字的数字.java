package cn.fyihan.������ϰ;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class LeetCode1365�ж���С�ڵ�ǰ���ֵ����� {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            int count = treeMap.getOrDefault(num, 0) + 1;
            treeMap.put(num, count);
        }
        int[] res = new int[nums.length];
        Set<Integer> keySet = treeMap.keySet();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            Iterator<Integer> iter = keySet.iterator();
            while (iter.hasNext()) {
                int key = iter.next();
                if (key >= target) {
                    break;
                }
                res[i] += treeMap.get(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1365�ж���С�ڵ�ǰ���ֵ����� test = new LeetCode1365�ж���С�ڵ�ǰ���ֵ�����();
        int[] res = test.smallerNumbersThanCurrent(new int[]{8, 1, 2, 3, 3});
        for (int i : res) {
            System.out.print(i);
        }
    }
}
