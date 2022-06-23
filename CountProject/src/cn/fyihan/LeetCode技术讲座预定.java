package cn.fyihan.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode技术讲座预定 {

    private Map<Integer, boolean[][]> sessionSeatMap = new HashMap<>();

    public static void main(String[] args) {
        LeetCode技术讲座预定 test01 = new LeetCode技术讲座预定();
        int interval = 2;
        int[][] orders = {{0, 1, 1}, {0, 0, 2}, {1, 1, 1}, {1, 0, 2, 0, 0}, {3, 0, 2}};
        System.out.println(test01.getSuccessfulNum(interval, orders));
    }

    public int getSuccessfulNum(int interval, int[][] orders) {
        int orderSucessNum = 0;
        for (int[] order : orders) {
            // 不符合规定的订单
            if (order == null || order.length % 2 != 1) {
                continue;
            }
            // 获取场次
            int session = getSessionNum(order[0], interval);
            if (sessionSeatMap.containsKey(session)) {

            }
            boolean[][] seats = sessionSeatMap.getOrDefault(session, new boolean[100][100]);
            for (int i = 1; i < order.length; i+=2) {
                if (seats[order[i]][order[i+1]] == false) {
                    seats[order[i]][order[i+1]] = true;
                    sessionSeatMap.put(session, seats);
                    orderSucessNum ++;
                }
            }
        }
        return orderSucessNum;
    }

    private Integer getSessionNum(int day, int interval) {
        return day / interval + 1;
    }
}
