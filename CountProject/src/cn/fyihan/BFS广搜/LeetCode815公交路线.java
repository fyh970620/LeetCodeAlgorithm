package cn.fyihan.BFS广搜;

import java.util.*;

public class LeetCode815公交路线 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source) { // 起始点一样
            return 0;
        }
        int rows = routes.length;
        boolean[][] intersept = new boolean[rows][rows];
        // 站点经过车辆
        Map<Integer, List<Integer>> stationMap = new HashMap<>();
        for (int i=0; i<rows; i++) {
            for (Integer staticn : routes[i]) {
                List<Integer> arrCars = stationMap.getOrDefault(staticn, new ArrayList<Integer>());
                for (Integer car : arrCars) {
                    // arrCars中本身有值，则该车辆之间互通
                    intersept[i][car] = true;
                    intersept[car][i] = true;
                }
                arrCars.add(i);
                stationMap.put(staticn, arrCars);
            }
        }
        // 队列初始化
        int[] useBusCount = new int[rows];
        Arrays.fill(useBusCount, -1);
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> arrCars = stationMap.getOrDefault(source, new ArrayList<Integer>());
        for (int car : arrCars) {
            useBusCount[car] = 1;
            queue.offer(car);
        }
        while(!queue.isEmpty()) {
            int arrCar = queue.poll(); // 需要乘坐的车
            for (int i = 0; i< rows; i++) {
                if (intersept[arrCar][i]
                        && useBusCount[i] == -1) {
                    useBusCount[i] = useBusCount[arrCar] + 1;
                    queue.offer(i);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : stationMap.getOrDefault(target, new ArrayList<Integer>())) {
            if (useBusCount[bus] != -1) {
                ret = Math.min(ret, useBusCount[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
