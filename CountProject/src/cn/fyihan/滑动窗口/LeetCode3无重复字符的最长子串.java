package cn.fyihan.滑动窗口;

public class LeetCode3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        String scenStr = "";
        for (int i=0; i<chars.length; i++){
            if (!scenStr.contains(chars[i]+"")) {
                scenStr += chars[i];
                continue;
            }
            int rpeatIndex = scenStr.indexOf(chars[i]);
            maxLength = Math.max(maxLength, scenStr.length());
            start += rpeatIndex;
            scenStr = scenStr.substring(rpeatIndex+1) + chars[i];
        }
        maxLength = Math.max(maxLength, scenStr.length());
        return maxLength;
    }

    public static void main(String[] args) {
        LeetCode3无重复字符的最长子串 test = new LeetCode3无重复字符的最长子串();
        test.lengthOfLongestSubstring("aab");
    }
}
