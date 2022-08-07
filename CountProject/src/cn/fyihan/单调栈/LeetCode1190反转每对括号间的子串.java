package com.lagou.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode1190反转每对括号间的子串 {
    public String reverseParentheses(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<Character> originStack = new Stack<>();
        char[] originChars = s.toCharArray();
        for (char originChar : originChars) {
            if (originChar == ')') {
                Queue<Character> queue = new LinkedList<>();
                while (true) {
                    char changeChar = originStack.pop();
                    if (changeChar == '(') {
                        while (!queue.isEmpty()) {
                            originStack.push(queue.poll());
                        }
                        break;
                    }
                    queue.add(changeChar);
                }
                continue;
            }
            originStack.push(originChar);
        }
        String res = "";
        while (!originStack.isEmpty()) {
            res = originStack.pop() + res;
        }
        return res;
    }
}
