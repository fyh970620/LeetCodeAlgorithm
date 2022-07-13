package com.lagou.exam;

import java.util.Stack;

public class LeetCode735行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        while (index < asteroids.length) {
            if (stack.isEmpty() || asteroids[index] * stack.peek() > 0) {
                // 第一颗不用考虑方向 || 同方向
                stack.push(asteroids[index++]);
                continue;
            }
            int num = asteroids[index];
            if (num * stack.peek() < 0) {
                // 不同方向，会发生碰撞
                while (!stack.isEmpty()) {
                    if ((stack.peek() < 0 && num > 0) || stack.peek() * num > 0) {
                        stack.push(num);
                        index++;
                        break;
                    }
                    if (Math.abs(stack.peek()) > Math.abs(num)) {
                        index++;
                        break;
                    }
                    if (Math.abs(stack.peek()) == Math.abs(num)) {
                        stack.pop();
                        index++;
                        break;
                    }
                    stack.pop();
                }
            }
        }
        int[] rtRes = new int[stack.size()];
        int startIndex = stack.size() - 1;
        while (!stack.isEmpty()) {
            rtRes[startIndex--] = stack.pop();
        }
        return rtRes;
    }

    public static void main(String[] args) {
        LeetCode735行星碰撞 test = new LeetCode735行星碰撞();
        // test.asteroidCollision(new int[]{5,10,-5});
        test.asteroidCollision(new int[]{-2, -2, 1, -2});
    }
}
