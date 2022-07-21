package cn.fyihan.��������;

import java.util.Arrays;

public class LeetCodeMs1606��С�� {
    public int smallestDifference(int[] a, int[] b) {
        // �ȶ������������
        Arrays.sort(a);
        Arrays.sort(b);
        int idexa = 0;
        int idexb = 0;
        int minestDiffer = Math.abs(a[idexa] - b[idexb + 1]) < 0 ?
                Integer.MAX_VALUE : Math.abs(a[idexa] - b[idexb + 1]);
        idexb++;
        int lastDiffer = minestDiffer;
        while (idexa < a.length && idexb < b.length) {
            int currDiffer = Math.abs(a[idexa] - b[idexb]);
            if (currDiffer > lastDiffer) {
                // �Ѿ����򣬺������ü��㣬��ֵ����
                idexa++;
                if (idexa >= a.length) {
                    break;
                }
                lastDiffer = Math.abs(a[idexa] - b[idexb - 1]) < 0 ?
                        Integer.MAX_VALUE : Math.abs(a[idexa] - b[idexb - 1]);
                minestDiffer = Math.min(lastDiffer, minestDiffer);
                continue;
            }
            idexb++;
            lastDiffer = currDiffer;
            minestDiffer = Math.min(minestDiffer, currDiffer);
        }
        return minestDiffer;
    }

    public static void main(String[] args) {
        LeetCodeMs1606��С�� test = new LeetCodeMs1606��С��();
        // test.smallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8});
        // test.smallestDifference(new int[]{-1, -3, -15, -11, -2}, new int[]{-23, -127, -235, -19, -8});
        // test.smallestDifference(new int[]{-1, -3, 15, 11, 2}, new int[]{-23, -127, -235, -19, -8});
        test.smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
    }
}

