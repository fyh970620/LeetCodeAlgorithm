package cn.fyihan.集中练习;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCodeoffer13机器人的运动范围 {
    private int totalCount = 1;

    private Set<String> downStep = new HashSet<String>();

    private Queue<int[]> queue = new LinkedList<>();

    private Integer maxRow;

    private Integer maxCol;

    public int movingCount(int m, int n, int k) {
        maxRow = m;
        maxCol = n;
        queue.add(new int[]{0, 0});
        downStep.add("0-0");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currInex = queue.poll();
                // 向上走
                upOne(currInex[0], currInex[1], k);
                // 向下走
                upDown(currInex[0], currInex[1], k);
                // 向左走
                upLeft(currInex[0], currInex[1], k);
                // 向右走
                upRight(currInex[0], currInex[1], k);
            }
        }
        return totalCount;
    }

    private void upRight(int row, int col, int k) {
        if (row + 1 >= maxRow || downStep.contains((row + 1) + "-" + col)) {
            return;
        }
        boolean isStep = countNum(row + 1 + "", col + "", k);
        if (isStep) {
            queue.add(new int[]{row + 1, col});
            downStep.add(row + 1 + "-" + col);
            totalCount++;
        }
    }


    private void upLeft(int row, int col, int k) {
        if (row - 1 < 0 || downStep.contains((row - 1) + "-" + col)) {
            return;
        }
        boolean isStep = countNum(row - 1 + "", col + "", k);
        if (isStep) {
            queue.add(new int[]{row - 1, col});
            downStep.add(row - 1 + "-" + col);
            totalCount++;
        }
    }


    private void upDown(int row, int col, int k) {
        if (col + 1 >= maxCol || downStep.contains(row + "-" + (col + 1))) {
            return;
        }
        boolean isStep = countNum(row + "", col + 1 + "", k);
        if (isStep) {
            queue.add(new int[]{row, col + 1});
            downStep.add(row + "-" + (col + 1));
            totalCount++;
        }
    }

    private void upOne(int row, int col, int k) {
        if (col - 1 < 0 || downStep.contains(row + "-" + (col - 1))) {
            return;
        }
        boolean isStep = countNum(row + "", col - 1 + "", k);
        if (isStep) {
            queue.add(new int[]{row, col - 1});
            downStep.add(row + "-" + (col - 1));
            totalCount++;
        }
    }

    private Boolean countNum(String row, String col, int k) {
        int res = 0;
        for (int i = 0; i < row.length(); i++) {
            res += Integer.parseInt(row.charAt(i) + "");
            if (res > k) {
                return false;
            }
        }
        for (int i = 0; i < col.length(); i++) {
            res += Integer.parseInt(col.charAt(i) + "");
            if (res > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCodeoffer13机器人的运动范围 test = new LeetCodeoffer13机器人的运动范围();
        System.out.println(test.movingCount(3, 2, 17));
    }
}
