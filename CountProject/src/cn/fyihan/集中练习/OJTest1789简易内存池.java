package cn.fyihan.集中练习;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OJTest1789简易内存池 {
    static class AllocatedMemory {

        private boolean[] isAllowReq;

        private Map<Integer, Integer> isAllowScope;

        AllocatedMemory() {
            isAllowReq = new boolean[100];
            isAllowScope = new HashMap<>();
        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {
            if (size == 0) {
                return "error";
            }
            int start = 0;
            int end = start + size - 1;
            int idex = start;
            while (end < isAllowReq.length && idex <= end) {
                if (isAllowReq[idex] == true) {
                    int isEnd = isAllowScope.get(start);
                    start = isEnd + 1;
                    idex = start;
                    end = start + size - 1;
                    continue;
                }
                idex++;
            }
            if (end >= isAllowReq.length) {
                return "error";
            }
            isAllowScope.put(start, end);
            Arrays.fill(isAllowReq, start, end + 1, true);
            return start + "";
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            if (isAllowScope.containsKey(startAddress)) {
                int endAddress = isAllowScope.get(startAddress);
                Arrays.fill(isAllowReq, startAddress, endAddress + 1, false);
                return true;
            }
            return false;
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }
}
