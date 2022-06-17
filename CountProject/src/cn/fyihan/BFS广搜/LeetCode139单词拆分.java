package cn.fyihan.BFS广搜;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<Integer>();
        // 初始遍历位置
        queue.add(0);

        Boolean[] isTraverse = new Boolean[s.length()];
        Arrays.fill(isTraverse, false);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index == s.length()) {
                return true;
            }
            if (isTraverse[index]) {
                continue;
            }
            // 表示已经遍历过了该情况
            isTraverse[index] = true;
            for (int i=index + 1; i<=s.length(); i++) {
                if (wordDict.contains(s.substring(index, i))) {
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode139单词拆分 test = new LeetCode139单词拆分();
        System.out.println(test.wordBreak("LeetCode", Arrays.asList("Leets", "Code")));
    }
}
