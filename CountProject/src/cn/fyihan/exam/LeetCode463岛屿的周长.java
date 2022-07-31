package com.lagou.exam;

public class LeetCode463岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int roundSum = 0;
        int row = grid.length;
        int col = grid[0].length;
        // 横向
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (j - 1 < 0 || (j - 1 >= 0 && grid[i][j - 1] == 0)) {
                    roundSum += 1;
                }
                if (j + 1 == col || j + 1 < col && grid[i][j + 1] == 0) {
                    roundSum += 1;
                }
            }
        }
        // 纵向
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == 0) {
                    continue;
                }
                if (j - 1 < 0 || (j - 1 >= 0 && grid[j - 1][i] == 0)) {
                    roundSum += 1;
                }
                if (j + 1 == row || j + 1 < row && grid[j + 1][i] == 0) {
                    roundSum += 1;
                }
            }
        }
        return roundSum;
    }
}
