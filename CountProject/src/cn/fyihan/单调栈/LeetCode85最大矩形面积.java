package cn.fyihan.单调栈;

public class LeetCode85最大矩形面积 {

    public static void main(String[] args) {
        maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        });
    }

    public static int maximalRectangle(char[][] matrix) {
        int xlength = matrix.length;
        if(xlength == 0) {
            return 0;
        }
        int ylength = matrix[0].length;
        // int数组默认值为0
        int[][] width = new int[xlength][ylength];
        // 单调栈思路: 计算宽度
        for(int i=0; i<xlength; i++) {
            for(int y=0; y<ylength; y++) {
                if(matrix[i][y] == '1' ) {
                    if(y == 0) {
                        width[i][y] = 1;
                        continue;
                    }
                    width[i][y] = width[i][y-1] + 1;
                }
            }
        }
        int maxArea = 0;
        for(int i=0; i<xlength; i++) {
            for(int y=0; y<ylength; y++) {
                if(matrix[i][y] == '0') {
                    continue;
                }
                // 面积大小(当前行水平数组保证的“最小”面积)
                int area = width[i][y] * 1;
                int countWidth = width[i][y];
                // 计算长度
                for(int x= i-1; x>=0; x--){
                    countWidth = Math.min(countWidth, width[x][y]);
                    area = Math.max(area, (i-x+1) * countWidth);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
