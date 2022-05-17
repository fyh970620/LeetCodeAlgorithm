package cn.fyihan.单调栈;

import java.util.Stack;

public class LeetCode84柱状图中的最大矩形 {

    public static void main(String[] args) {
        largestRectangleArea(new int[]{0, 9});
    }

    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        // 左边最近的比当前位置长度要小的index
        int[] left = new int[length];
        // 右边最近的比当前位置长度要小的index
        int[] right = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty()? length : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for(int i=0; i<length; i++) {
            int temp =( right[i] - left[i] - 1 ) * heights[i];
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
}

