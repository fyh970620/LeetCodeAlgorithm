package cn.fyihan.递归;

public class LeetCode509斐波那契数 {

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        for(int i = 2; i<n; i++){
            int temp = start + end;
            start = end;
            end = temp;
        }
        return start + end;
    }
}
