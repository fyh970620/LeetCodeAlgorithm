package cn.fyihan.并查集;

public class LeetCode200岛屿数量 {

    int[] collDatas;

    int wholeSize;

    int length;
    int low;

    /*public static void main(String[] args) {
        char[][] gridnum = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
    }*/

    public int numIslands(char[][] grid) {
        length = grid.length;
        low = grid[0].length;

        init();
        for(int i=0; i<length; i++) {
            for(int j=0; j<low; j++) {
                if(grid[i][j] == '1') {
                    union(grid, i, j);
                    continue;
                }
                wholeSize --;
            }
        }
        return wholeSize;
    }

    // 初始化
    public void init(){
        collDatas = new int[length * low];
        for(int i=0; i<length; i++) {
            for(int j=0; j<low; j++) {
                collDatas[i*low + j] = i * low + j;
            }
        }
        wholeSize = length * low;
    }

    public void union(char[][] grid, int indexX, int indexY) {
        if(indexX -1 >= 0 && grid[indexX-1][indexY] == '1') {
            unionDetail(indexX * low + indexY, (indexX-1) * low + indexY);
        }
        if(indexX + 1 < length && grid[indexX+1][indexY] == '1') {
            unionDetail(indexX * low + indexY, (indexX+1) * low + indexY);
        }
        if(indexY + 1 < low && grid[indexX][indexY + 1] == '1') {
            unionDetail(indexX * low + indexY, indexX * low + indexY + 1);
        }
        if(indexY - 1 >= 0 && grid[indexX][indexY - 1] == '1') {
            unionDetail(indexX * low + indexY, indexX * low + indexY - 1);
        }
    }

    public void unionDetail(int i, int j) {
        int left = findIndex(i);
        int right = findIndex(j);
        if(left != right) {
            collDatas[left] = right;
            wholeSize --;
        }
    }

    public int findIndex(int i) {
        if(collDatas[i] == i) {
            return i;
        }
        return collDatas[i] = findIndex(collDatas[i]);
    }
}
