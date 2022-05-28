package cn.fyihan.二分查找;

public class LeetCode33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断左右侧是否有序
            boolean res = judgeOrderly(nums, start, mid);
            if (res){
                if (nums[mid] > target && nums[start] < target) {
                    end = mid;
                    continue;
                } else {
                    // 在无序中寻找
                    start = mid + 1;
                    continue;
                }
            } else {
                // 说明右侧有序
                if (nums[mid] < target && nums[end] > target) {
                    start = mid +1;
                    continue;
                } else {
                    // 在无序中寻找
                    end = mid;
                    continue;
                }
            }
        }
        return -1;
    }

    private Boolean judgeOrderly(int[] orderlyNums, int start, int end) {
        if (orderlyNums[start] > orderlyNums[end]) {
            //无序
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode33搜索旋转排序数组 test = new LeetCode33搜索旋转排序数组();
        test.search(new int[]{5,1,3}, 0);
    }
}
