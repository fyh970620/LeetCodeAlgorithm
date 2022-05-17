package cn.fyihan.单调栈;

import java.util.Stack;

public class LeetCode739每日温度 {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{
                73,74,75,71,69,72,76,73
        });
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.peek()] = 0;
            stack.pop();
        }
        return answer;
    }
}
