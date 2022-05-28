package cn.fyihan.二分查找;

public class LeetCode240搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] countNums: matrix) {
            if(binarySearch(countNums,target)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] targetNum, int target) {
        int start = 0;
        int end = targetNum.length;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int tempNum = targetNum[mid];
            if (tempNum > target) {
                end = mid - 1;
            }
            if (tempNum == target) {
                return true;
            }
            if (tempNum < target) {
                start = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode240搜索二维矩阵II test = new LeetCode240搜索二维矩阵II();
        test.searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}

        },5);
    }

}
