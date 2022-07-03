package com.lagou.exam;

/**
 * 注意学会indexOf(‘’，fromIndex) 的用法
 */
public class LeetCode1055形成字符串的最短路径 {

    public int shortestWay(String source, String target) {
        if (source.equals(target)) {
            return 1;
        }
        int count = 1;
        int currentIndex = 0;
        char[] chars = target.toCharArray();
        for (char c : chars) {
            int index = source.indexOf(c, currentIndex);
            if (index == -1) {
                if (source.indexOf(c) == -1) {
                    return -1;
                }
                currentIndex = source.indexOf(c) + 1;
                count++;
                continue;
            }
            currentIndex = index + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1055形成字符串的最短路径 test = new LeetCode1055形成字符串的最短路径();
        // System.out.println(test.shortestWay("abc", "abcbc"));
    }
}
