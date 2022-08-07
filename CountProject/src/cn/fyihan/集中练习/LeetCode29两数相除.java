package com.lagou.exam;

public class LeetCode29两数相除 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = dividend < 0 ^ divisor < 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int quotient = 0;
        int currDivisor = divisor, factor = 1;
        // 被除数先右移一位，因为Integer.MIN_VALUE比Integer.MAX_VALUE大1，
        // 计算时候，都用负数的形式参与计算可以不用越界，正变负的情况
        while (dividend >> 1 < currDivisor) {
            currDivisor <<= 1;
            factor <<= 1;
        }
        while (dividend <= divisor) {
            while (dividend > currDivisor) {
                currDivisor >>= 1;
                factor >>= 1;
            }
            quotient += factor;
            dividend -= currDivisor;
        }
        if (negative) {
            quotient = -quotient;
        }
        return quotient;
    }

    public static void main(String[] args) {
        LeetCode29两数相除 test = new LeetCode29两数相除();
        test.divide(2147483647,
                2);
    }
}