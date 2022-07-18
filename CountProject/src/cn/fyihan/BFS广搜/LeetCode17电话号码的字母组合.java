package com.lagou.exam;

import java.util.*;

public class LeetCode17电话号码的字母组合 {
    private Map<Integer, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        buildDirMap();
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> rtRes = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        int idex = 0;
        while (idex < digits.length()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                char[] x = map.get(Integer.parseInt(digits.charAt(idex) + ""));
                for (char c : x) {
                    queue.add(str + c);
                }
            }
            idex++;
        }
        if (queue.isEmpty()) {
            return new ArrayList<>();
        }
        while (!queue.isEmpty()) {
            rtRes.add(queue.poll());
        }
        return rtRes;
    }

    private void buildDirMap() {
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        LeetCode17电话号码的字母组合 test = new LeetCode17电话号码的字母组合();
        System.out.println(test.letterCombinations("23"));
        System.out.println(test.letterCombinations(""));
        System.out.println(test.letterCombinations("2"));
    }
}
