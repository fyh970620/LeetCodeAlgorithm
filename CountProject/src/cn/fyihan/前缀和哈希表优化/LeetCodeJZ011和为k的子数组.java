package cn.fyihan.ǰ׺�͹�ϣ���Ż�;

public class LeetCodeJZ011��Ϊk�������� {
    public int subarraySum(int[] nums, int k) {
        int[] sumNums = new int[nums.length];
        sumNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumNums[i] = nums[i] + sumNums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumNums[i] == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (sumNums[j] - sumNums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
