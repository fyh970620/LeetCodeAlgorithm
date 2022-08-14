package com.lagou.exam;

public class LeetCode304二维区域和检索矩阵不可变 {
    private int[][] regionMatrix = null;

    public LeetCode304二维区域和检索矩阵不可变(int[][] matrix) {
        this.regionMatrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col ++) {
                sum += regionMatrix[row][col];
            }
        }
        return sum;
    }
}
