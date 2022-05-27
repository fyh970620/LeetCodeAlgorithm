package cn.fyihan.方差;

public class LeetCode1109航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flightNum = new int[n+1];
        for (int i=0; i<bookings.length; i++) {
            int[] booking = bookings[i];
            /** booking：[航班保留seats起始位置、从1开始对应数组前一位坐标,
             *            航班保留seats最后位置、从该位置向后一位坐标开始下航班，但对应数组需要前移，所以抵消不变,
             *            保留seats人数]
             **/
            flightNum[booking[0]-1] = flightNum[booking[0]-1] + booking[2];
            flightNum[booking[1]] = flightNum[booking[1]] - booking[2];
        }

        int[] answer = new int[n];
        answer[0] = flightNum[0];
        for (int i=1 ;i<n; i++) {
            answer[i] = answer[i-1] + flightNum[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        LeetCode1109航班预订统计 test = new LeetCode1109航班预订统计();
        test.corpFlightBookings(new int[][]{
                {1,2,10},{2,3,20},{2,5,25}
        },5);
    }
}
