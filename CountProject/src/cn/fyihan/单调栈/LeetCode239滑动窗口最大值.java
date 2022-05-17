package cn.fyihan.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        // 初始化
        for(int i=0; i<k; i++){
           while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
               deque.pollLast();
           }
           deque.addLast(i);
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        //滑动窗口
        for(int i=k; i<nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while(deque.peekFirst() <= i-k) {
                // 超出的部分删除
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
