package com.lagou.exam;

public class LeetCode34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                end = mid - 1;
                continue;
            }
            int minStart = lminIdex(mid, nums, start, target);
            int maxEnd = rMaxIndex(nums, mid, end, target);
            return new int[]{minStart, maxEnd};
        }
        return new int[]{-1, -1};
    }

    private int rMaxIndex(int[] nums, int start, int end, int target) {
        // 因为是递增，右边的值只有可能等于或者比target大
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] != target) {
                end = mid - 1;
                continue;
            }
            // 如果等于
            start = mid + 1;
        }
        return end;
    }

    private int lminIdex(int end, int[] nums, int start, int target) {
        // 因为是递增，左边的只有可能比target小，不等于则移动start
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] != target) {
                start = mid + 1;
                continue;
            }
            // 如果等于
            end = mid;
        }
        return end;
    }

    public static void main(String[] args) {
        LeetCode34在排序数组中查找元素的第一个和最后一个位置 test = new LeetCode34在排序数组中查找元素的第一个和最后一个位置();
        test.searchRange(new int[]{1, 2, 3}, 2);

    }
}
