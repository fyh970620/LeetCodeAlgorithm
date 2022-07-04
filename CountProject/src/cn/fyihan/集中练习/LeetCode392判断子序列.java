package cn.fyihan.集中练习;

public class LeetCode392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        char[] sources = s.toCharArray();
        int newMatchIndex = -1;
        for (char c : sources) {
            newMatchIndex = t.indexOf(c, newMatchIndex + 1);
            if (newMatchIndex == -1) {
                return false;
            }
        }
        return true;
    }
}