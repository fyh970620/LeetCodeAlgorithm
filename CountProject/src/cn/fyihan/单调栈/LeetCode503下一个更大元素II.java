package cn.fyihan.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int[] resNums = new int[nums.length];
        // 全部赋值 -1
        Arrays.fill(resNums, -1);
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        // 第一次循环
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                resNums[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        // 第二次循环: 不在push数据
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                resNums[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        return resNums;
    }
}


