package com.lagou.exam;

import java.util.*;

public class LeetCode460LFU缓存 {
    private Map<Integer, String> dataMap;

    private Map<Integer, FreduqueNode> freduqueMap;

    private Integer capacity;

    private Integer nowCap;

    private Integer miniIndex;

    public LeetCode460LFU缓存 (int capacity) {
        this.dataMap = new HashMap<>();
        this.freduqueMap = new HashMap<>();
        this.capacity = capacity;
        nowCap = 0;
        this.miniIndex = 0;
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            String[] res = dataMap.get(key).split("-");
            int frequeNum = Integer.parseInt(res[1]) + 1;
            FreduqueNode node = freduqueMap.getOrDefault(frequeNum, new FreduqueNode());
            // 被调用过，放在该调用次数的最前列
            node.linkedList.addFirst(key + "");
            // 重新存入数据值
            int resNum = Integer.parseInt(res[0]);
            dataMap.put(key,resNum +"-" +frequeNum);
            freduqueMap.put(frequeNum, node);
            FreduqueNode afterNode = freduqueMap.get(Integer.parseInt(res[1]));
            afterNode.linkedList.remove(key + "");
            if (afterNode.linkedList.size() == 0) {
                freduqueMap.remove(Integer.parseInt(res[1]));
                if (miniIndex == Integer.parseInt(res[1])) {  // 说明向上移动的是最小的
                    miniIndex += 1;
                }
            }
            return resNum;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (dataMap.containsKey(key)) {
            get(key);
            String[] res = dataMap.get(key).split("-");
            dataMap.put(key, value + "-" + res[1]);
            return;
        }
        if (capacity == nowCap) {
            nowCap -= 1;
            FreduqueNode minNode = freduqueMap.get(miniIndex);
            Integer rmKey = Integer.parseInt(minNode.linkedList.getLast());
            dataMap.remove(rmKey);
            minNode.linkedList.removeLast();
            if (minNode.linkedList.size() == 0) {
                freduqueMap.remove(miniIndex);
                miniIndex += 1;
            }
        }
        dataMap.put(key, value + "-" + 1);
        miniIndex = 1;
        FreduqueNode freduqueNode = freduqueMap.getOrDefault(1, new FreduqueNode());
        freduqueNode.linkedList.addFirst(key + "");
        freduqueMap.put(1, freduqueNode);
        nowCap += 1;
    }

    public class FreduqueNode {
        private LinkedList<String> linkedList = new LinkedList<String>();

        public FreduqueNode() {
        }
    }

    public static void main(String[] args) {
        LeetCode460LFU缓存 test = new LeetCode460LFU缓存(10);
        test.put(10,13);
        test.put(3,17);
        test.put(6,11);
        test.put(10,5);
        test.put(9,10);
        test.get(13);
        test.put(2,19);
        test.get(2);
        test.get(3);
        test.put(5,25);
        test.get(8);
        test.put(9,22);
        test.put(5,5);
        test.put(1,30);
        test.get(11);
        test.put(9,12);
        test.get(7);
        test.get(5);
        test.get(8);
        test.get(9);
        test.put(4,30);
        test.put(9,3);
        test.get(9);
        test.get(10);
        test.put(6,14);
        test.put(3,1);
        test.get(3);
        test.put(10,11);
        test.get(8);
        test.put(2,14);
        test.get(1);
        test.get(5);
        test.get(4);
        test.put(11,4);
        test.put(12,24);
        test.put(5,18);
        test.get(13);
        test.put(7,23);
        test.get(8);
        test.get(12);
        test.put(3,27);
        test.put(2,12);
        test.get(5);
        test.put(2,9);
        test.put(13,4);
        test.put(8,18);
        test.put(1,7);
        test.get(6);
        test.put(9,29);
        test.put(8,21);
        test.get(5);
        test.put(6,30);
        test.put(1,12);
        test.get(10);
        test.put(4,15);
        test.put(7,22);
        test.put(11,26);
        test.put(8,17);
        test.put(9,29);
        test.get(5);
        test.put(3,4);
        test.put(11,30);
        test.get(12);
        test.put(4,29);
        test.get(3);
        test.get(9);
        test.get(6);
        test.put(3,4);
        test.get(1);
        test.get(10);
        test.put(3,29);
        test.put(10,28);
        test.put(1,20);
        test.put(11,13);
        test.get(3);
        test.put(3,12);
        test.put(3,8);
        test.put(10,9);
        test.put(3,26);
        test.get(8);
        test.get(7);
        test.get(5);
        test.put(13,17);
        test.put(2,27);
        test.put(11,15);
        test.get(12);
        test.put(9,19);



    }
}


