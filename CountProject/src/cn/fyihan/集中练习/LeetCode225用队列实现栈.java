package cn.fyihan.集中练习;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225用队列实现栈 {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    public LeetCode225用队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            return;
        }
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.poll();
        }
        return queue1.poll();
    }

    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        }
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode225用队列实现栈 test = new LeetCode225用队列实现栈();
        test.push(1);
        test.push(2);
    }
}
