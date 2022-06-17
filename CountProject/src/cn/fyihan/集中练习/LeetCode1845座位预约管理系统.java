package cn.fyihan.集中练习;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LeetCode1845座位预约管理系统 {

    PriorityQueue<Integer> queue;
    int i=1;

    public LeetCode1845座位预约管理系统(int n) {
        queue=new PriorityQueue<>();
    }

    public int reserve() {
        if(!queue.isEmpty()) return queue.poll();
        else return i++;
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
