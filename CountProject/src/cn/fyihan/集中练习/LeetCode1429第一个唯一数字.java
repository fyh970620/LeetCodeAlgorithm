package cn.fyihan.exam.LeetCodeTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1429第一个唯一数字 {
    // 独立存在的容器
    private Set<Integer> uniqueNum = new HashSet<>();

    // 表示已经存在的
    private Set<Integer> existNum = new HashSet<>();

    // 保证顺序的情况下， 该数字第一次出现时才存储
    private List<Integer> numDatas = new ArrayList<>();

    public LeetCode1429第一个唯一数字(int[] nums) {
        for (int num : nums) {
            if (existNum.contains(num)) {
                // 已经存在
                if (uniqueNum.contains(num)) {
                    uniqueNum.remove(num);
                }
                continue;
            }
            // 并不存在
            numDatas.add(num);
            existNum.add(num);
            uniqueNum.add(num);
        }
    }

    public int showFirstUnique() {
        if (numDatas.size() == 0) {
            return -1;
        }
        for (int num : numDatas) {
            if (uniqueNum.contains(num)) {
                return num;
            }
        }
        return -1;
    }

    public void add(int value) {
        // 重复出现
        if (existNum.contains(value)) {
            if (uniqueNum.contains(value)) {
                uniqueNum.remove(value);
            }
            return;
        }
        // 非重复出现
        existNum.add(value);
        uniqueNum.add(value);
        numDatas.add(value);
    }

    public static void main(String[] args) {
        LeetCode1429第一个唯一数字 test = new LeetCode1429第一个唯一数字(new int[]{1});
        test.add(1);
        test.add(1);
        test.showFirstUnique();
    }
}



