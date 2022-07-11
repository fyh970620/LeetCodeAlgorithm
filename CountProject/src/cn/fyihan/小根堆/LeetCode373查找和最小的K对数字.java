package com.lagou.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode373查找和最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> treeSet = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        List<List<Integer>> rtRes = new ArrayList<List<Integer>>();
        int len = Math.min(nums1.length, k);
        for (int i = 0; i < len; i++) {
            treeSet.offer(new int[]{i, 0});
        }
        while (k > 0) {
            int[] tempNum = treeSet.poll();
            if (tempNum == null || tempNum.length == 0) {
                break;
            }
            rtRes.add(Arrays.asList(nums1[tempNum[0]], nums2[tempNum[1]]));
            k--;
            if (tempNum[1] + 1 < nums2.length) {
                treeSet.offer(new int[]{tempNum[0], tempNum[1] + 1});
            }
        }
        return rtRes;
    }
}
