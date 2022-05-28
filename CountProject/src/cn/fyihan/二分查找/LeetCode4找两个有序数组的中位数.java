package cn.fyihan.二分查找;

public class LeetCode4找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 假定nums1为长度较短的那个数组
        if (nums1.length > nums2.length) {
            int[] tempNum = nums2;
            nums2 = nums1;
            nums1 = tempNum;
        }
        int leftCount = (nums1.length + nums2.length + 1) / 2;
        int left = 0;
        int right = nums1.length;
        while (left < right) {
            // nums1左边的个数
            int midIndex = (left+right+1) / 2;
            // nums2左边的个数
            int sndLeftNum = leftCount - midIndex;
            // 要求划线，线左侧的数都小于右边的数
            if (nums1[midIndex-1] > nums2[sndLeftNum]) {
                // 线需要左移动 [left, midIndex-1]
                right = midIndex - 1;
            } else {
                // 线需要右移 [midIndex, right]
                left = midIndex;
            }
        }
        // 分割线
        int firIndex = left;
        int sndIndex = leftCount - left;
        // 左侧值
        int firleftNum = firIndex == 0? Integer.MIN_VALUE: nums1[firIndex-1];
        int sndleftNum = sndIndex == 0? Integer.MIN_VALUE: nums2[sndIndex-1];
        // 右侧值
        int firRightNum = firIndex == nums1.length ? Integer.MAX_VALUE: nums1[firIndex];
        int sndRightNum = sndIndex == nums2.length ? Integer.MAX_VALUE: nums2[sndIndex];
        if ((nums1.length + nums2.length) % 2 == 1 ) {
            // 奇数， 取左侧中最大的值
            return Math.max(firleftNum, sndleftNum);
        } else {
            // 偶数， 取左侧最大的值和右侧最小的值的平均数
            return (Math.max(firleftNum, sndleftNum) + Math.min(firRightNum, sndRightNum)) / 2.0;
        }
    }

    public static void main(String[] args) {
        LeetCode4找两个有序数组的中位数 test = new LeetCode4找两个有序数组的中位数();
        test.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}
