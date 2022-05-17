package cn.fyihan.单调栈;


import java.util.Stack;

public class LeetCode962最大宽坡度 {

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        // 递减序列
        for(int i=0; i<nums.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int maxSlop = 0;
        // 从尾部遍历数组
        for(int i=nums.length-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int slopStartIndex = stack.pop();
                maxSlop = Math.max(maxSlop, i-slopStartIndex);
            }
        }
        return maxSlop;
    }

    public static void main(String[] args) {
        maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
    }
}
