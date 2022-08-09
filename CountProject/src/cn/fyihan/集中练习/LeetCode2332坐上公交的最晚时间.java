package com.lagou.exam;

import java.util.Arrays;

public class LeetCode2332坐上公交的最晚时间 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int pIdex = 0;
        for (int i = 0; i < buses.length; i++) {
            int startTime = buses[i];
            int tempCapcity = capacity;
            while (tempCapcity > 0 && pIdex < passengers.length && passengers[pIdex] <= startTime) {
                pIdex++;
                tempCapcity--;
            }
            if (i == buses.length - 1) {
                if (tempCapcity > 0 && (pIdex - 1 >= 0 && passengers[pIdex - 1] != startTime) || pIdex == 0) {
                    return startTime;
                }
            }
        }
        // 特殊情况： 最后一位因为不能相同时间到达，可乘区间到达人数全部沾满
        pIdex--;
        while (pIdex >= 0 && pIdex - 1 >= 0) {
            if (passengers[pIdex] - passengers[pIdex - 1] != 1) {
                return passengers[pIdex] - 1;
            }
            pIdex --;
        }
        return passengers[pIdex] - 1;
    }
}
