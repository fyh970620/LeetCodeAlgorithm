package cn.fyihan.集中练习;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Oj1794最长的指定瑕疵度的元音子串 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int flaw = Integer.parseInt(cin.nextLine());
        String input = cin.nextLine();
        cin.close();

        System.out.println(getLongestFlawedVowelSubstrLen(flaw, input));
    }

    private static final String ORIGIN_LETTER = "aeiouAEIOU";

    // 待实现函数，在此函数中填入答题代码
    private static int getLongestFlawedVowelSubstrLen(int flaw, String input) {
        int start = 0;
        int end = 0;
        // 获取首个原字符
        while (end < input.length()) {
            if (ORIGIN_LETTER.contains(input.charAt(end) + "")) {
                // 首个原字符
                start = end;
                break;
            }
            end++;
        }
        if (start != end) {
            return 0;
        }
        // 从首个元字符处开始滑动窗口
        int noOriLetterNum = 0;
        int maxLength = Integer.MIN_VALUE;
        while (end < input.length()) {
            if (!ORIGIN_LETTER.contains(input.charAt(end) + "")) {
                // 非原音
                noOriLetterNum++;
            }
            if (ORIGIN_LETTER.contains(input.charAt(end) + "")) {
                if (noOriLetterNum == flaw) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
                if (noOriLetterNum > flaw) {
                    while (start <= end) {
                        if (!ORIGIN_LETTER.contains(input.charAt(++start) + "")) {
                            noOriLetterNum--;
                            continue;
                        }
                        if (ORIGIN_LETTER.contains(input.charAt(start) + "")) {
                            if (noOriLetterNum == flaw) {
                                maxLength = Math.max(maxLength, end - start + 1);
                                break;
                            }
                            if (noOriLetterNum < flaw) {
                                break;
                            }
                        }
                    }
                }
            }
            end++;
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
