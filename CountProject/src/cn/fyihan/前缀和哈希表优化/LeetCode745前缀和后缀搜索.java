package com.lagou.exam;

import java.util.HashMap;
import java.util.Map;

public class LeetCode745前缀和后缀搜索 {

    private Map<String, Integer> dicMap = new HashMap<>();

    public LeetCode745前缀和后缀搜索(String[] words) {
        int index = 0;
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefx = word.substring(0, i);
                for (int j = 1; j <= word.length(); j++) {
                    String suff = word.substring(word.length() - j);
                    dicMap.put(prefx + "-" + suff, index);
                }
            }
            index++;
        }
    }

    public int f(String pref, String suff) {
        String key = pref + "-" + suff;
        if (!dicMap.containsKey(key)) {
            return -1;
        }
        return dicMap.get(key);
    }

    // 暴力
    /* public int f(String pref, String suff) {
        int slen = pref.length();
        int elen = suff.length();
        char[] prefChars = pref.toCharArray();
        char[] suffChars = suff.toCharArray();
        for (int i = dicWords.length -1; i >= 0; i--) {
            String compareStr = dicWords[i];
            int compareLen = compareStr.length();
            // target ab  pref = ab suff = ab 也是合法用例
            if (elen > compareStr.length() || slen > compareStr.length() ) {
                continue;
            }
            boolean isOk = true;
            for (int j=0; j<slen&& isOk; j++) {
                if (compareStr.charAt(j) != prefChars[j]) {
                    isOk = false;
                    break;
                }
            }
            for (int j=0; j<elen && isOk; j++) {
                if (compareStr.charAt(compareLen - 1 - j) != suffChars[elen - 1 - i]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                return i;
            }
        }
        return -1;
    }*/


}
