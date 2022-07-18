package cn.fyihan.������ϰ;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OJTest1789�����ڴ�� {
    static class AllocatedMemory {

        private boolean[] isAllowReq;

        private Map<Integer, Integer> isAllowScope;

        AllocatedMemory() {
            isAllowReq = new boolean[100];
            isAllowScope = new HashMap<>();
        }

        // ���ط�����ڴ��׵�ַ(string)��ʧ�ܷ����ַ��� "error"
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

        // �ɹ����� true��ʧ�ܷ��� false��ʧ��ʱ��ܻ��Զ���� "error"
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
     * main�����OJƽ̨����
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
