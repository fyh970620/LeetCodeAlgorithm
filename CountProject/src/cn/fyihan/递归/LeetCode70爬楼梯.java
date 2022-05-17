package cn.fyihan.递归;

public class LeetCode70爬楼梯 {
    /**
     * timeout
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 循环代替递归
     *
     * @param n
     * @return
     */
    public int climbStairNoTimeOut(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int start = 1;
        int end = 2;
        for (int i = 3; i < n; i++) {
            int temp = start + end;
            start = end;
            end = temp;
        }
        return start + end;
    }
}