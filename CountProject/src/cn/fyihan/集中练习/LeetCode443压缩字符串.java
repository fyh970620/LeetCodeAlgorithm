package cn.fyihan.exam.LeetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode443压缩字符串 {
    public int compress(char[] chars) {
        int s = 0;
        int count = 1;
        int length = chars.length;
        List<Character> list = new ArrayList<Character>();
        for (int i = 1; i < length; i++) {
            if (chars[i] != chars[s]) {
                list.add(chars[s]);
                if (count > 1) {
                    String countStr = count + "";
                    for (int j = 0; j < countStr.length(); j++) {
                        list.add(countStr.charAt(j));
                    }
                }
                count = 1;
                s = i;
                continue;
            }
            count++;
        }
        list.add(chars[s]);
        if (count > 1) {
            String countStr = count + "";
            for (int j = 0; j < countStr.length(); j++) {
                list.add(countStr.charAt(j));
            }
        }
        chars = new char[length];
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return chars.length;
    }

    public static void main(String[] args) {
        LeetCode443压缩字符串 test = new LeetCode443压缩字符串();
        test.compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'});
    }
}
