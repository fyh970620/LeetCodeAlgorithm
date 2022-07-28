package com.lagou.exam;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1631最小体力消耗路径 {
    // 四个方向 左，右，上，下
    private final int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int maxX = heights.length;
        int maxY = heights[0].length;
        int start = 0;
        int end = (int)Math.pow(10.0, 6) - 1;
        int rtRes = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            boolean[] isSeen = new boolean[maxX * maxY];
            isSeen[0] = true;
            while (!queue.isEmpty()) {
                int[] nowstep = queue.poll();
                int x = nowstep[0];
                int y = nowstep[1];
                for (int j = 0; j < direction.length; j++) {
                    // 开始4个方向移动
                    int[] move = direction[j];
                    int newX = move[0] + x;
                    int newY = move[1] + y;
                    if (newY >= 0 && newY < maxY && newX >= 0 && newX < maxX
                            && !isSeen[newX * maxY +newY] && Math.abs(heights[newX][newY] - heights[x][y]) <= mid) {
                        isSeen[newX * maxY +newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            if (isSeen[maxX * maxY - 1]) {
                rtRes = Math.min(mid, rtRes);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return rtRes;
    }
}
