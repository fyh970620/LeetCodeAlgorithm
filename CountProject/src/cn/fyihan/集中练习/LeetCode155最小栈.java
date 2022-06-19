package com.lagou.exam;

import java.util.Stack;

public class LeetCode155最小栈 {

    private Stack<Integer> dataStack;

    private Stack<Integer> auxStack;

    public LeetCode155最小栈() {
        dataStack = new Stack<Integer>();
        auxStack = new Stack<Integer>();
    }

    public void push(int val) {
        dataStack.push(val);
        if (auxStack.isEmpty()) {
            auxStack.push(val);
            return;
        }
        if (auxStack.peek() >= val) {
            auxStack.push(val);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return;
        }
        Integer outNum = dataStack.peek();
        dataStack.pop();
        if (outNum.equals(auxStack.peek())){
            auxStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return auxStack.peek();
    }

    public static void main(String[] args) {
        LeetCode155最小栈 test = new LeetCode155最小栈();
        test.push(512);
        test.push(-1024);
        test.push(-1024);
        test.push(512);
        test.pop();
        test.getMin();
        test.pop();
        test.getMin();
        test.pop();
        test.getMin();
    }
}
