package cn.fyihan.滑动窗口;

public class LeetCode1208尽可能使字符串相等 {
    public static void main(String[] args) {
        LeetCode1208尽可能使字符串相等 test = new LeetCode1208尽可能使字符串相等();
        test.equalSubstring("abcd",  "cdef", 1);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int maxLength = Integer.MIN_VALUE;
        int countCost = 0;
        int start = 0;
        int end = 0;
        while (end < t.length()) {
            countCost += Math.abs(Integer.valueOf(t.charAt(end)) - Integer.valueOf(s.charAt(end)));
            while (countCost > maxCost) {
                countCost  =countCost - (Math.abs(Integer.valueOf(t.charAt(start)) - Integer.valueOf(s.charAt(start))));
                start ++ ;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end ++ ;
        }
        maxLength = maxLength == Integer.MIN_VALUE? 0: maxLength;
        return maxLength;
    }
}
