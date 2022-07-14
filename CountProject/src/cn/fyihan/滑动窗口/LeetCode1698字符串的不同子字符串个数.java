package com.lagou.exam;


import java.util.HashSet;
import java.util.Set;

public class LeetCode1698字符串的不同子字符串个数 {
    public int countDistinct(String s) {
        int start = 0;
        int end = 1;
        Set<String> cutStrSet = new HashSet<String>();
        while (start < s.length()) {
            cutStrSet.add(s.substring(start, end++));
            if (end > s.length()) {
                start++;
                end = start + 1;
            }
        }
        return cutStrSet.size();
    }

    public static void main(String[] args) {
        LeetCode1698字符串的不同子字符串个数 test = new LeetCode1698字符串的不同子字符串个数();
        test.countDistinct("aab");
    }
}
