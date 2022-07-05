package cn.fyihan.集中练习;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Oj1904四则运算求值 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();
        String result = calculate(expression);
        System.out.println(result);
    }

    private final static List<Character> FIR_OPERATION_SYBOLS = Arrays.asList('*', '/');

    private final static List<Character> SND_OPERATION_SYBOLS = Arrays.asList('+', '-');

    // 待实现函数，在此函数中填入答题代码
    private static String calculate(String expression) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int index = 0;
        if (expression.startsWith("-") || expression.startsWith("+")) {
            expression = "0" + expression;
        }
        while (index < expression.length()) {
            char sybol = expression.charAt(index);
            if (!FIR_OPERATION_SYBOLS.contains(sybol) && !SND_OPERATION_SYBOLS.contains(sybol)) {
                index++;
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(Integer.parseInt(expression.substring(start, index)));
                start = index + 1;
                continue;
            }
            int tempIndex = start;
            while (tempIndex < expression.length() && !FIR_OPERATION_SYBOLS.contains(expression.charAt(tempIndex))
                    && !SND_OPERATION_SYBOLS.contains(expression.charAt(tempIndex))) {
                tempIndex++;
            }
            int nowNum = Integer.parseInt(expression.substring(start, tempIndex));
            index = tempIndex;
            start = index + 1;
            if (FIR_OPERATION_SYBOLS.contains(sybol)) {
                if (FIR_OPERATION_SYBOLS.get(0) == sybol) {
                    stack.push(stack.pop() * nowNum);
                } else {
                    if (nowNum == 0) {
                        return "error";
                    }
                    stack.push(stack.pop() / nowNum);
                }
                continue;
            }
            if (SND_OPERATION_SYBOLS.contains(sybol)) {
                if (SND_OPERATION_SYBOLS.get(0) == sybol) {
                    stack.push(nowNum);
                } else {
                    stack.push((-1) * nowNum);
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res + "";
    }
}
