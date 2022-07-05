package cn.fyihan.集中练习;

import java.util.Stack;

public class LeetCode394字符串解码 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        int index = 0;
        while (index < s.length()) {
            char symbol = s.charAt(index);
            if (symbol < '0' || symbol > '9') {
                if (symbol == ']') {
                    String res = "";
                    String tempSybol = stack.pop();
                    while (!tempSybol.equals("[")) {
                        res = tempSybol + res;
                        tempSybol = stack.pop();
                    }
                    // 获取需要重复的次数
                    String finalRes = "";
                    int repeatNum = Integer.parseInt(stack.pop());
                    for (int i = 0; i < repeatNum; i++) {
                        finalRes += res;
                    }
                    stack.push(finalRes + "");
                    index ++;
                    continue;
                }
                stack.push(symbol + "");
                index ++;
                continue;
            }
            // 为数字
            int start = index++;
            symbol = s.charAt(index);
            while (symbol <= '9' && symbol >= '0') {
                index++;
                symbol = s.charAt(index);
            }
            stack.push(s.substring(start, index));
        }
        String rtRes = "";
        while (!stack.isEmpty()) {
            rtRes = stack.pop() + rtRes;
        }
        return rtRes;
    }

    public static void main(String[] args) {
        LeetCode394字符串解码 test = new LeetCode394字符串解码();
        test.decodeString("3[a]2[bc]");
    }
}
