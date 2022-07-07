package cn.fyihan.BFS广搜;

import java.util.*;

public class LeetCode752打开转盘锁 {
    public int openLock(String[] deadends, String target) {
        List<String> deadLocks = Arrays.asList(deadends);
        // 防止一直循环
        Set<String> isUsedLock = new HashSet<String>();
        if (deadLocks.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int minOperatorNum = 0;
        while (!queue.isEmpty()) {
            int batchSize = queue.size();
            for (int i = 0; i < batchSize; i++) {
                String currLock = queue.poll();
                if (currLock.equals(target)) {
                    return minOperatorNum;
                }
                if (deadLocks.contains(currLock) || isUsedLock.contains(currLock)) {
                    // 死锁，应该被跳过不能继续拧
                    continue;
                }
                isUsedLock.add(currLock);
                for (int j = 0; j < 4; j++) {
                    // 当前位置可以向上也可以向下拧
                    queue.add(upOne(currLock, j));
                    queue.add(downOne(currLock, j));
                }
            }
            minOperatorNum++;
        }
        return -1;
    }

    private String downOne(String originStr, int index) {
        char[] originChars = originStr.toCharArray();
        if (originChars[index] == '0') {
            originChars[index] = '9';
        } else {
            originChars[index] -= 1;
        }
        return new String(originChars);
    }

    private String upOne(String originStr, int index) {
        char[] originChars = originStr.toCharArray();
        if (originChars[index] == '9') {
            originChars[index] = '0';
        } else {
            originChars[index] += 1;
        }
        return new String(originChars);
    }
}
