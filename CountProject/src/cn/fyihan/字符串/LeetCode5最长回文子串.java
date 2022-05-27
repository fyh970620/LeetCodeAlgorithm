package cn.fyihan.字符串;

public class LeetCode5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int length = s.length();
        int startIndex = 0;
        int endIndex = 0;
        for (int i=0; i<length; i++) {
            // 奇数回文数长度
            int oddLen = countPalindromeLen(length, i, i, s);
            // 偶数回文数长度
            int evenLen = countPalindromeLen(length, i, i+1, s);
            int tempLen = Math.max(oddLen, evenLen);
            if (tempLen > endIndex - startIndex ) {
                startIndex = i - (tempLen-1) / 2 ;
                endIndex = i + tempLen / 2;
            }
        }
        return s.substring(startIndex, endIndex+1);
    }

    private int countPalindromeLen(int length, int leftIndex, int rightIndex, String s) {
        while ( leftIndex >=0 && rightIndex < length && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex --;
            rightIndex ++;
        }
        return rightIndex - leftIndex - 1;
    }
}
