package com.lagou.exam;

import java.util.HashSet;
import java.util.Set;

public class LeetCode676魔法字典 {

    // 字典表
    private Set<String> dics;

    public LeetCode676魔法字典() {
        dics = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (String dicWord : dictionary) {
            dics.add(dicWord);
        }
    }

    public boolean search(String searchWord) {
        char[] words = searchWord.toCharArray();
        for (int i = 0; i < searchWord.length(); i++) {
            char targetchar = searchWord.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (targetchar != j) {
                    words[i] = j;
                    if (dics.contains(String.valueOf(words))) {
                        return true;
                    }

                }
            }
            words[i] = targetchar;
        }
        return false;
    }
}
