package cn.fyihan.�ַ���;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LeetCode763������ĸ���� {
    public List<Integer> partitionLabels(String s) {
        int start = 0;
        int end = s.lastIndexOf(s.charAt(0));
        int idex = 1;
        List<Integer> rtRes = new ArrayList<>();
        while (end < s.length()) {
            if (end == start) {
                rtRes.add(1);
                start++;
                idex = start + 1;
                if (start >= s.length()) break;
                end = s.lastIndexOf(s.charAt(start));
                continue;
            }
            if (idex == end) {
                rtRes.add(end - start + 1);
                start = end + 1;
                idex = start + 1;
                if (start >= s.length()) break;
                end = s.lastIndexOf(s.charAt(start));
                continue;
            }
            int currEnd = s.lastIndexOf(s.charAt(idex));
            if (currEnd < 0 || currEnd < end) {
                idex++;
                continue;
            }
            if (currEnd >= end) {
                end = currEnd;
                idex++;
                continue;
            }
        }
        return rtRes;
    }

    public static void main(String[] args) {
        LeetCode763������ĸ���� test = new LeetCode763������ĸ����();
        test.partitionLabels("eaaaabaaec");
    }
}
