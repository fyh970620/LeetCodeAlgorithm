package cn.fyihan.集中练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56合并区间 {
    private List<int[]> rtRes = new ArrayList<>();

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(nums -> nums[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] detail = intervals[i];
            if (detail[0] > end) {
                rtRes.add(new int[]{start, end});
                start = detail[0];
                end = detail[1];
                continue;
            }
            if (end >= detail[1]) {
                continue;
            }
            end = detail[1];
        }
        rtRes.add(new int[]{start, end});
        int[][] rtNums = new int[rtRes.size()][2];
        for (int i = 0; i < rtRes.size(); i++) {
            rtNums[i] = rtRes.get(i);
        }
        return rtNums;
    }
}
