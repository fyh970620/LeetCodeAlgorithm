package cn.fyihan.¶ş·Ö²éÕÒ;

public class LeetCode74ËÑË÷¶şÎ¬¾ØÕó {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        for (int i =0; i<matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            int start = 0;
            int end = col - 1;
            if (matrix[i][start] == target || matrix[i][end] == target) {
                return true;
            }
            int mid = (start + end) / 2;
            while (start < end) {
                if (matrix[i][start] == target || matrix[i][end] == target) {
                    return true;
                }
                if (matrix[i][mid] < target) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                    continue;
                }
                if (matrix[i][mid] > target) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                    continue;
                }
                if (matrix[i][mid] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode74ËÑË÷¶şÎ¬¾ØÕó test = new LeetCode74ËÑË÷¶şÎ¬¾ØÕó();
        test.searchMatrix(new int[][]{
                {1}
        }, 1);
    }
}
