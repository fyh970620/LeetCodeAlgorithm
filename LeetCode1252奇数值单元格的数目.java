package com.lagou.exam;

public class LeetCode1252奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] originNums = new int[m][n];
        int count = 0;
        for (int[] num : indices) {
            int x = num[0];
            int y = num[1];
            for (int i = 0; i < n; i++) {
                // 行不变
                int tempNums = originNums[x][i];
                if (tempNums == 0) {
                    //初始化第一次
                    if (i == y) {
                        originNums[x][i] += 2;
                        continue;
                    }
                    originNums[x][i] += 1;
                    count++;
                    continue;
                }
                // 非第一次计算
                if (i == y) {
                    originNums[x][i] += 2;
                    continue;
                }
                originNums[x][i] += 1;
                if (originNums[x][i] % 2 == 0) {
                    // 原数据为奇数
                    count--;
                    continue;
                }
                // 原数据为偶数
                count++;
                continue;
            }
            for (int i = 0; i < m; i++) {
                // 列不变
                if (i == x) {
                    // 目标点在行不变时已经处理，跳过
                    continue;
                }
                int tempNum = originNums[i][y];
                if (tempNum == 0) {
                    // 原位置第一次添加
                    originNums[i][y] += 1;
                    count++;
                    continue;
                }
                // 非原位置第一次添加
                originNums[i][y] += 1;
                if (originNums[i][y] % 2 == 0) {
                    // 上次数据为奇数
                    count--;
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1252奇数值单元格的数目 test = new LeetCode1252奇数值单元格的数目();
        test.oddCells(2, 3, new int[][]{
                {0, 1},
                {1, 1}
        });
    }
}
