package com.lagou.exam;

import java.util.Stack;

public class LeetCode232用栈实现队列 {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    public LeetCode232用栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(x);
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return 0;
    }

    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return 0;
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode232用栈实现队列 test = new LeetCode232用栈实现队列();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.pop();
    }
}
