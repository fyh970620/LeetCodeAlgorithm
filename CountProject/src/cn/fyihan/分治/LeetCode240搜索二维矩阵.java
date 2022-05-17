package cn.fyihan.分治;

public class LeetCode240搜索二维矩阵 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] < target){
                    continue;
                }
                if(matrix[i][j] == target){
                    return true;
                }
                if(matrix[i][j] > target){
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        searchMatrix(new int[][]{
                {1,4},{2,5}
        },4);
    }
}
