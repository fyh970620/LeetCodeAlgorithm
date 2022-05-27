package cn.fyihan.拓扑排序;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode210课程表 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储有向图 制定初始化长度防止重复触发扩容机制
        List<List<Integer>> directGrahs = new ArrayList<List<Integer>>(numCourses);
        for (int i=0; i<numCourses; i++) {
            directGrahs.add(new ArrayList<Integer>());
        }
        // 存储当前节点有多少节点是指向自己的
        int[] asscoiaNum = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            directGrahs.get(prerequisite[1]).add(prerequisite[0]);
            asscoiaNum[prerequisite[0]] = asscoiaNum[prerequisite[0]]+1;  // 关联数+1;
        }
        // 节点存入取出的队列
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<numCourses; i++) {
            // 将没有关联的节点先存入队列中
            if (asscoiaNum[i] == 0) {
                queue.add(i);
            }
        }
        // 返回结果的数组
        int[] rtResult = new int[numCourses];
        int index = 0;
        while( !queue.isEmpty() ){
            int noAsscoiIndex = queue.poll();
            rtResult[index++] = noAsscoiIndex;
            // 查看 该节点指向了那些节点
            for (int arrGraph : directGrahs.get(noAsscoiIndex)) {
                // 当前指向该节点的点已经入库，那么指向的数量-1;
                asscoiaNum[arrGraph] = asscoiaNum[arrGraph]-1;
                if (asscoiaNum[arrGraph] == 0) {  // 该节点也没有指向它的节点了，需入库队列
                    queue.add(arrGraph);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return rtResult;
    }
}
