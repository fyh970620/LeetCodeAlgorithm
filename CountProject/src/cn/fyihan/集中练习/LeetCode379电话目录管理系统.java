package cn.fyihan.集中练习;

import java.util.Arrays;

public class LeetCode379电话目录管理系统 {
    private boolean[] outerStays;

    private Integer curHasNum;

    public LeetCode379电话目录管理系统(int maxNumbers) {
        this.curHasNum = maxNumbers;
        this.outerStays = new boolean[maxNumbers];
        Arrays.fill(outerStays, true);
    }

    public int get() {
        if (curHasNum == 0) {
            return -1;
        }
        int getNum = -1;
        for (int i = 0; i < outerStays.length; i++) {
            if (outerStays[i]) {
                outerStays[i] = false;
                getNum = i;
                curHasNum -= 1;
                break;
            }
        }
        return getNum;
    }

    public boolean check(int number) {
        return outerStays[number];
    }

    public void release(int number) {
        outerStays[number] = true;
        curHasNum += 1;
        return;
    }
}
