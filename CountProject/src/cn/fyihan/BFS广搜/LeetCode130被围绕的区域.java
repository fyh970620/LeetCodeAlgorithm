package cn.fyihan.BFS广搜;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130被围绕的区域 {
    // 四个方向上
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {

        // 看四条边
        int columnTotal = board[0].length;   // 列
        int rowTotal = board.length;   // 行
        for (int j = 0; j < columnTotal; j++) {
            // 第一行
            if (board[0][j] == 'O') {
                isAround(board, 0, j, columnTotal, rowTotal);
            }
            // 最后一行
            if (board[rowTotal-1][j] == 'O') {
                isAround(board, rowTotal-1, j, columnTotal, rowTotal);
            }
        }

        for (int i = 0; i< rowTotal; i++) {
            // 第一列
            if (board[i][0] == 'O') {
                isAround(board, i, 0, columnTotal, rowTotal);
            }
            // 最后一列
            if (board[i][columnTotal-1] == 'O') {
                isAround(board, i, columnTotal-1, columnTotal, rowTotal);
            }
        }

        for (int i=0; i<rowTotal; i++) {
            for (int j=0; j<columnTotal; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    private void isAround(char[][] board, int i, int j, int columnTotal, int rowTotal) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x < rowTotal && point.y < columnTotal && point.x >= 0 && point.y >= 0
                    && board[point.x][point.y] == 'O') {
                board[point.x][point.y] = 'B';
                for (int k=0; k<dirs.length; k++) {
                    queue.add(new Point(point.x+dirs[k][0], point.y+dirs[k][1]));
                }
            }
        }
    }


    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        LeetCode130被围绕的区域 test = new LeetCode130被围绕的区域();
        test.solve(new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        });

    }
}
