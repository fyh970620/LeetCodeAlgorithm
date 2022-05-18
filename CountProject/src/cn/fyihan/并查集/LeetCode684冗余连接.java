package cn.fyihan.并查集;

public class LeetCode684冗余连接 {

    public static void main(String[] args) {
        LeetCode684冗余连接 test = new LeetCode684冗余连接();
        test.findRedundantConnection(new int[][]{
                {1,2},
                {1,3},
                {2,3}
        });
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionCollection unionCollection = new UnionCollection(edges.length+1);
        for(int i=0; i<edges.length; i++){
            int[] result = unionCollection.union(edges[i][0], edges[i][1]);
            if(result.length == 2){
                return result;
            }
            continue;
        }
        return null;
    }

    class UnionCollection{
        int[] unionRoots;

        public UnionCollection(int length) {
            unionRoots = new int[length];
            // 初始化集合
            for(int i=0; i<length; i++) {
                unionRoots[i] = i;
            }
        }

        // 返回当前i指向的上一个代表节点
        public int find(int i){
            if(i == unionRoots[i]) {
                return i;
            }
            return unionRoots[i] = find(unionRoots[i]);
        }

        public int[] union(int i, int j){
            int left = find(i);
            int right = find(j);
            if(left == right) {
                // 说明出现了闭环
                return new int[]{i,j};
            }else{
                unionRoots[left] = right;
            }
            return new int[]{};
        }
    }
}
