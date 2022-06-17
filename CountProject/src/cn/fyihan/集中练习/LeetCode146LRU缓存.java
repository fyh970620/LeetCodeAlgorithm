package cn.fyihan.集中练习;

import java.util.*;

public class LeetCode146LRU缓存 {

    private Deque<Integer> queue;

    private int capacity;

    private Map<Integer, Integer> lruMap;

    public LeetCode146LRU缓存(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.lruMap = new HashMap<>();
    }


    public int get(int key) {
        if (lruMap.containsKey(key)) {
            queue.remove(key);
            queue.addFirst(key);
            return lruMap.get(queue.peek());
        }
        return -1;
    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            lruMap.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }
        if (queue.size() >= capacity) {
            int lastKey =  queue.getLast();
            lruMap.remove(lastKey);
            queue.pollLast();
        }
        queue.addFirst(key);
        lruMap.put(key, value);
    }

    public static void main(String[] args) {
        LeetCode146LRU缓存 test = new LeetCode146LRU缓存(2);
        test.get(2);
        test.put(2,6);
        test.get(1);
        test.put(1,5);
        test.put(1,2);
        test.get(1);
        test.get(2);
    }
}
