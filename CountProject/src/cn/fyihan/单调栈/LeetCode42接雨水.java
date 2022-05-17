package cn.fyihan.单调栈;

import java.util.Stack;

public class LeetCode42接雨水 {
    public static int trap(int[] height) {
        int length = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for(int i=0; i<length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                //认定为形成低洼
                int shortIndex = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int shortHeight = Math.min(height[i], height[stack.peek()]) - height[shortIndex];
                maxArea += width * shortHeight;
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap(test);
    }
}

