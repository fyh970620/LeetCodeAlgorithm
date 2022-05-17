package cn.fyihan.projectFirst;

import java.util.stream.Stream;

/**
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti
 * 包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 *
 * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
 *
 * eg1: 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 *      输出：[10,55,45,25,25]
 *      解释：
 *      航班编号        1   2   3   4   5
 *      预订记录 1 ：   10  10
 *      预订记录 2 ：       20  20
 *      预订记录 3 ：       25  25  25  25
 *      总座位数：      10  55  45  25  25
 *      因此，answer = [10,55,45,25,25]
 *
 *      1 <= n <= 2 * 104
 *      1 <= bookings.length <= 2 * 104
 *      bookings[i].length == 3
 *      1 <= firsti <= lasti <= n
 *      1 <= seatsi <= 104
 */
public class LeetCode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] statCount = new int[n];

        //Step1
        for (int[] book : bookings) {
            int start = book[0] - 1;     //start
            int end = book[1] - 1;     //end
            int value = book[2];

            //i-j范围内增加到值,j+1后面进行减少值
            statCount[start] = statCount[start] + value;   //start value
            if (end + 1 < statCount.length) {
                statCount[end + 1] = statCount[end + 1] - value;  //end -value
            }
        }

        //Step2
        int[] res = new int[statCount.length];
        res[0] = statCount[0];  //从0 station开始计算

        for (int i = 1; i < statCount.length; i++) {
            res[i] = res[i - 1] + statCount[i];
        }
        return res;
    }

    /**
     * [[1,2,10],[2,3,20],[2,5,25]]
     * 5
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode1109 test = new LeetCode1109();
        test.corpFlightBookings(new int[][] {
                {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        }, 5);
        final Stream<String> stream = Stream.of("“Red”", "”Blue”", "”Green”");
    }
}

