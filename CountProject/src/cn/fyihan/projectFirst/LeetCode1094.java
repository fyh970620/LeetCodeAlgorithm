package cn.fyihan.projectFirst;

/**
 * 车上最初有capacity个空座位。车只能向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数capacity和一个数组 trips , trip[i] = [numPassengersi, fromi, toi]
 * 表示第 i 次旅行有numPassengersi乘客，接他们和放他们的位置分别是fromi和toi。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false。
 *
 * eg1: 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 *      输出：false
 *
 * eg2: 输入：trips = [[3,3,7],[2,1,5]], capacity = 5
 *      输出：true
 *
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi<= 100
 * 0 <= fromi< toi<= 1000
 * 1 <= capacity <= 105
 *
 */
public class LeetCode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        if(capacity < 0){
            return false;
        }
        //Step1
        int[] statCount = new int[1001];
        int maxId = 0;
        for(int[] t : trips){    //[2,1,5]
            maxId = Math.max(maxId, t[1]);
            statCount[t[1]] = statCount[t[1]] + t[0];
            statCount[t[2]] = statCount[t[2]] - t[0];
        }

        //Step2
        int[] totalCap = new int[1001];

        totalCap[0] = statCount[0];
        for(int x=1; x<= maxId; x++){
            totalCap[x] = totalCap[x-1] + statCount[x];   //到达站台i时，总共容纳的人数
            if(totalCap[x] > capacity){
                return false;
            }
        }
        return true;
    }

    /**
     * [[9,0,1],[3,3,7]]  用例问题 存在从0-》1
     *  4
     * @param args
     */
    public static void main(String[] args) {
        LeetCode1094 test = new LeetCode1094();
        Boolean res = test.carPooling(new int[][]{
                {3,3,7},
                {2,1,5}
        },5);
        System.out.println(res);
    }
}
