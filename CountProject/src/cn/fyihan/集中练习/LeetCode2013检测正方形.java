package com.lagou.exam;

public class LeetCode2013检测正方形 {
    private int[][] wholeNum;

    public LeetCode2013检测正方形() {
        wholeNum = new int[1001][1001];
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        wholeNum[x][y] += 1;
    }

    public int count(int[] point) {
        int count = 0;
        int x = point[0];
        int y = point[1];
        for (int i = 0; i < 1001; i++) {
            // x轴找边
            if (wholeNum[x][i] > 0 && i != y) {
                // 计算距离
                int distance = Math.abs(i - y);
                // y轴找边
                if (x + distance < 1001 && wholeNum[x + distance][y] > 0) {
                    count += wholeNum[x + distance][y] * wholeNum[x][i] * wholeNum[x + distance][i];
                }
                if (x - distance >= 0 && wholeNum[x - distance][y] > 0) {
                    count += wholeNum[x - distance][y] * wholeNum[x][i] * wholeNum[x - distance][i];
                }
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */