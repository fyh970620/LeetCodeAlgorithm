package com.lagou.exam;

public class LeetCode69x的平方根 {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int rtRes = -1;
        while (start <= end) {
            // start+end可能会超int范围 int mid = (start + end) / 2;
            int mid = start + (end - start)/ 2;
            // mid * mid可能会超过int范围 对其中一个转long在计算会精度固定在long
            // long res = mid * mid;
            long res = (long)mid * mid;
            if (res > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
                rtRes = mid;
            }
        }
        return rtRes;
    }
}
