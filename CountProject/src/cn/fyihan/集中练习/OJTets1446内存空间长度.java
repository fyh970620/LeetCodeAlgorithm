package cn.fyihan.集中练习;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OJTets1446内存空间长度 {
    // 待实现函数，在此函数中填入答题代码
    private static int getValidLength(int[][] intervalSet) {
        Arrays.sort(intervalSet, Comparator.comparingInt(nums -> nums[0]));
        int start = intervalSet[0][0];
        int end = intervalSet[0][1];
        int totalLen = 0;
        for (int i = 0; i < intervalSet.length; i++) {
            int[] detail = intervalSet[i];
            if (detail[0] > end) {
                totalLen += end - start;
                end = detail[1];
                start = detail[0];
                continue;
            }
            if (end >= detail[1]) {
                continue;
            }
            end = detail[1];
        }
        totalLen += end - start;


        /* 超题目内存
        int[] capcity = new int[(int) Math.pow(10.0, 9.0)];
        int n = intervalSet.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] detail = intervalSet[i];
            capcity[detail[0]] = detail[1];
            max = Math.max(detail[1], max);
        }
        // 最大长度
        int maxTotalLength = max;
        int idex = 0;
        while (idex < maxTotalLength) {
            int step = capcity[idex];
            if (step == 0) {
                maxTotalLength--;
                idex++;
                continue;
            }
            while (idex < step) {
                idex++;
                step = Math.max(capcity[idex], step);
                continue;
            }
        }
        return maxTotalLength;*/
    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int row = cin.nextInt();
        int col = 2;
        int[][] intervalSet = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                intervalSet[i][j] = cin.nextInt();
            }
        }
        cin.close();

        int result = getValidLength(intervalSet);
        System.out.println(result);
    }
}
