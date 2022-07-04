package cn.fyihan.exam.LeetCodeTest;

import java.util.Arrays;

public class LeetCode875爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        Arrays.sort(piles);
        // 两个边界
        int length = piles.length;
        if (h == length) {
            return piles[length - 1];
        }
        if (length == 1) {
            return (int) Math.ceil((double) piles[0] / (double) h);
        }
        //
        int maxSpeed = piles[length - 1];
        int minSpeed = 0;
        int resSpeed = Integer.MAX_VALUE;
        while (minSpeed < maxSpeed) {
            int midSpeed = (int) Math.ceil((double) (maxSpeed + minSpeed) / 2.0);
            if (midSpeed == minSpeed || midSpeed == maxSpeed) {
                break;
            }
            int totalTimes = useTimes(piles, midSpeed);
            if (totalTimes == h) {
                resSpeed = Math.min(midSpeed, resSpeed);
                // 是否有更小的值
                maxSpeed = midSpeed;
                continue;
            }
            if (totalTimes > h) {
                // 太慢了
                minSpeed = midSpeed;
            } else {
                // 太快了
                maxSpeed = midSpeed;
            }
        }
        if (resSpeed == Integer.MAX_VALUE) {
            int useTime = useTimes(piles, minSpeed);
            if (useTime < h) {
                return minSpeed;
            }
            return maxSpeed;
        }
        return resSpeed;
    }

    private int useTimes(int[] piles, int speed) {
        int sumTime = 0;
        for (int pile : piles) {
            sumTime += (int) Math.ceil((double) pile / (double) speed);
        }
        return sumTime;
    }

    public static void main(String[] args) {
        /*// 测试用例1
        LeetCode875爱吃香蕉的珂珂 test = new LeetCode875爱吃香蕉的珂珂();
        int speed = test.minEatingSpeed(new int[]{3,6,7,11}, 8);
        System.out.println(speed);*/

        // 测试用例3
        LeetCode875爱吃香蕉的珂珂 test = new LeetCode875爱吃香蕉的珂珂();
        int speed = test.minEatingSpeed(new int[] {
                332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589,
                290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184
        }, 823855818);
        System.out.println(speed);
    }
}
