package cn.fyihan.集中练习;

import java.util.*;

public class LeetCode729我的日程安排表 {
    private TreeSet<int[]> treeSet;

    public static void main(String[] args) {
        LeetCode729我的日程安排表 test = new LeetCode729我的日程安排表();
        System.out.println(test.book(5, 6));
        System.out.println(test.book(7, 9));
        // System.out.println(test.book(6,8));
        System.out.println(test.book(4, 6));
        System.out.println("---end");
    }

    public LeetCode729我的日程安排表() {
        treeSet = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        if (treeSet.isEmpty()) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        // celling方法获取start >= end的最近区间值
        int[] arr = treeSet.ceiling(tmp);
        // 判断是否存在这样子的区间值
        int[] prev = arr == null ? treeSet.last() : treeSet.lower(arr);
        // lower方法判断在temp之下的最近一个，start是否大于等于其end
        if (arr == treeSet.first() || treeSet.lower(tmp)[1] <= start) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
