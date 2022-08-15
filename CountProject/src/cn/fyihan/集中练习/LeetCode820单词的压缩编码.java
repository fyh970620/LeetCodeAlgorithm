package com.lagou.exam;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode820单词的压缩编码 {
    public int minimumLengthEncoding(String[] words) {
        List<String> sortWords = Arrays.asList(words).stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }).collect(Collectors.toList());
        Set<String> wordsSet = new HashSet<String>(sortWords);
        int sumLen = 0;
        for (String word : sortWords) {
            if (!wordsSet.contains(word)) {
                continue;
            }
            int idex = word.length() - 1;
            while (idex >= 0) {
                String lastTriNode = word.substring(idex--);
                wordsSet.remove(lastTriNode);
            }
            sumLen += word.length() + 1;
        }
        return sumLen;
    }

    public static void main(String[] args) {
        LeetCode820单词的压缩编码 test = new LeetCode820单词的压缩编码();
        test.minimumLengthEncoding(new String[]{"time", "me", "bell"});
    }
}
