package com.lagou.exam;

import java.util.*;

public class LeetCode395至少有K个重复字符的最长子串 {
    private Integer maxLen = 0;

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> idexs = countMap.getOrDefault(chars[i], new ArrayList<>());
            idexs.add(i);
            countMap.put(chars[i], idexs);
        }
        List<Integer> idexs = new ArrayList<>();
        for (Map.Entry<Character, List<Integer>> entry : countMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (Integer idex : entry.getValue()) {
                    idexs.add(idex);
                }
            }
        }
        if (idexs.isEmpty() || s.length() < k) {
            return 0;
        }
        Collections.sort(idexs);
        if (idexs.size() == 1 && k == 1) {
            return 1;
        }
        if (idexs.size() == s.length()) {
            return s.length();
        }
        int startidex = 0;
        int endIdex = 1;
        while (endIdex < idexs.size()) {
            if (idexs.get(endIdex) - idexs.get(endIdex - 1) == 1) {
                endIdex ++;
                continue;
            }
            String subString = s.substring(idexs.get(startidex), idexs.get(endIdex - 1) + 1);
            maxLen = Math.max(longestSubstring(subString, k),maxLen);
            startidex = endIdex ++;
        }
        String finalStr = "";
        if (idexs.get(endIdex - 1) < s.length()) {
            finalStr = s.substring(idexs.get(startidex), idexs.get(endIdex - 1) + 1);
        } else {
            finalStr = s.substring(idexs.get(startidex));
        }
        maxLen = Math.max(maxLen, longestSubstring(finalStr,k));
        return maxLen;
    }
}
