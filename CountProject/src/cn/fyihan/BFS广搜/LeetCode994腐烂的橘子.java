package com.lagou.exam;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994腐烂的橘子 {
    public static void main(String[] args) {
        LeetCode994腐烂的橘子 test = new LeetCode994腐烂的橘子();
        test.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        });
    }

    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int noOrgins = 0;
        int days = 0;
        // 方向
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    continue;
                }
                if (grid[i][j] == 0) {
                    noOrgins++;
                }
            }
        }
        if (noOrgins == x * y) {
            // 没有橘子
            return 0;
        }
        // 没有腐烂的橘子
        if (queue.isEmpty()) {
            return -1;
        }
        int decySum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            decySum += size;
            for (int i = 0; i < size; i++) {
                int[] decyOrg = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int row = decyOrg[0] + dirs[j][0];
                    int col = decyOrg[1] + dirs[j][1];
                    if (row >= 0 && row < x && col >= 0 && col < y) {
                        if (grid[row][col] == 1) {
                            grid[row][col] = 2;
                            queue.add(new int[]{row, col});
                        }
                    }
                }
            }
            days++;
        }
        // 全部腐烂应该腐烂的数量
        int countDecy = x * y - noOrgins;
        if (countDecy == decySum) {
            return days - 1;
        }
        return -1;
    }
}
