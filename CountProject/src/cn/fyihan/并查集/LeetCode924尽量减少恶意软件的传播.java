package cn.fyihan.并查集;

import java.util.Arrays;

public class LeetCode924尽量减少恶意软件的传播 {

    public static void main(String[] args) {
        LeetCode924尽量减少恶意软件的传播 test = new LeetCode924尽量减少恶意软件的传播();
        test.minMalwareSpread(new int[][]{
                {1,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,1},
                {0,0,0,1,1,1},
                {0,0,0,1,1,1}
        }, new int[]{2,3});
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        UnionMalwareSpread union = new UnionMalwareSpread(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        // 用于描述每个节点在当前网络区中占的连通数量是否有唯一性
        int[] count = new int[graph.length];
        for (int i : initial) {
            ++count[union.find(i)];
        }
        int max = 0;
        int rtIndex = -1;
        for (int i : initial) {
            int index = union.find(i);
            // 是否传染源具有唯一性
            if (count[index] == 1) {
                int tempNum = union.areaSize[union.find(index)];
                if (tempNum > max) {
                    max = tempNum;
                    rtIndex = i;
                    continue;
                }
                if (tempNum == max && rtIndex > i) {
                    rtIndex = i;
                }
            }
        }
        // 没有满足受限传染源节点
        if (rtIndex == -1) {
            rtIndex = Integer.MAX_VALUE;
            for (int i : initial) {
                rtIndex = Math.min(rtIndex, i);
            }
        }
        return rtIndex;
    }

    /**
     * 并查集类
     */
    class UnionMalwareSpread {
        // 网络区域
        int[] area;
        // 网络区域大小
        int[] areaSize;
        // 初始化
        public UnionMalwareSpread(int n) {
            area = new int[n];
            areaSize = new int[n];
            for (int i=0; i<n; i++) {
                area[i] = i;
            }
            Arrays.fill(areaSize, 1);
        }

        public int find(int i) {
            if (area[i] == i) {
                return i;
            }
            return area[i] = find(area[i]);
        }

        public void union(int i, int j) {
            int left = find(i);
            int right = find(j);
            if (left != right) {
                area[left] = right;
                areaSize[right] += areaSize[left];
            }
        }
    }
}
