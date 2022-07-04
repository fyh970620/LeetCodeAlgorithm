package cn.fyihan.exam.LeetCodeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeetCode380插入删除和获取随机元素 {

    private Map<Integer, Integer> map;

    private int idex;

    private int[] nums;

    public LeetCode380插入删除和获取随机元素() {
        map = new HashMap<>();
        idex = -1;
        nums = new int[200001];
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, ++idex);
            nums[idex] = val;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer rmidex = map.remove(val);
        if (rmidex == idex) {
            idex--;
        } else {
            nums[rmidex] = nums[idex];
            map.put(nums[idex], rmidex);
            idex--;
        }
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return nums[rand.nextInt(idex + 1)];
    }
}
