package cn.fyihan.集中练习;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode150波兰表达式求值 {
    private final static List<String> operationSymbols = Arrays.asList("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!operationSymbols.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int num1 = stack.pop();
            int num2 = stack.pop();
            if ("+".equals(token)) {
                stack.push(num1 + num2);
                continue;
            }
            if ("-".equals(token)) {
                stack.push(num2 - num1);
                continue;
            }
            if ("*".equals(token)) {
                stack.push(num1 * num2);
                continue;
            }
            if ("/".equals(token)) {
                stack.push(num2 / num1);
                continue;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode150波兰表达式求值 test = new LeetCode150波兰表达式求值();
        test.evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }
}
