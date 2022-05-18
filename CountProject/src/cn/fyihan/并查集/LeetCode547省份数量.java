package cn.fyihan.并查集;

public class LeetCode547省份数量 {

    public static void main(String[] args) {
        LeetCode547省份数量 test = new LeetCode547省份数量();
        test.findCircleNum(new int[][]{
                {1,1,1},
                {1,1,1},
                {1,1,1}
        });
    }

    public int findCircleNum(int[][] isConnected) {
        // n * n 矩阵
        int n = isConnected.length;
        UnionClass unionClass = new UnionClass(n);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    // 满足同集合规定合并
                    unionClass.union(i,j);
                }
            }
        }
        return unionClass.lastColSize;
    }


    class UnionClass {
        int[] collRoots;
        int lastColSize;

        // 构造方法 并
        UnionClass(int collecitonSize){
            collRoots = new int[collecitonSize];
            for(int i=0; i<collecitonSize; i++) {
                collRoots[i] = i;
            }
            this.lastColSize = collecitonSize;
        }

        // 查
        public int find(int i){
            if(collRoots[i] == i) {
                return i;
            }
            // 0-1[f(0)=1; f(1)=1] 1-0[f(0)=0; f(1)=0]
            return collRoots[i] = find(collRoots[i]);
        }

        // 并
        public void union(int i, int j) {
            int scopeLeft = find(i);
            int scopeRight = find(j);
            if(scopeLeft != scopeRight){
                // 不相等时进行合并操作
                collRoots[scopeLeft] = scopeRight;
                lastColSize --;
            }
        }
    }
}
