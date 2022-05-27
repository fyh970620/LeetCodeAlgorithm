package cn.fyihan.差分;

public class LeetCode1094拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] poplFlow = new int[1000];
        // 最后上车站点
        int lastGetBusPlace = Integer.MIN_VALUE;
        for (int i=0; i<trips.length; i++) {
            int[] tempTripDetail =  trips[i];
            lastGetBusPlace = Math.max(lastGetBusPlace, tempTripDetail[1]);

            int flowPersons = tempTripDetail[0];
            // 统计该站点上车人数
            poplFlow[tempTripDetail[1]] = poplFlow[tempTripDetail[1]] + flowPersons;
            // 统计该站点下车人数
            poplFlow[tempTripDetail[2]] = poplFlow[tempTripDetail[2]] - flowPersons;
        }

        // 最后上车站点之前都没有超过cap，后面都是站点下车，不在有机会超过cap
        int nowPersons = 0 ;
        for (int i=0; i<=lastGetBusPlace; i++) {
            nowPersons += poplFlow[i];
            if (nowPersons > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1094拼车 test = new LeetCode1094拼车();
        test.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        },4);
    }
}
