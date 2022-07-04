package cn.fyihan.集中练习;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1396设计地铁系统 {
    // 站内乘客容器MAP
    private Map<Integer, Passenger> inStationMap;

    // 站点-站点 耗时集合
    private Map<String, List<Integer>> avgStationTimes;

    public LeetCode1396设计地铁系统() {
        inStationMap = new HashMap<>();
        avgStationTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (inStationMap.containsKey(id)) {
            System.out.println("该乘客已经在站内，无法重复进站！");
            return;
        }
        inStationMap.put(id, new Passenger(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (!inStationMap.containsKey(id)) {
            System.out.println("该乘客不在站内无法重复出站！");
            return;
        }
        Passenger passenger = inStationMap.get(id);
        // 获取行程key
        String tripKey = passenger.startStation + "-" + stationName;
        List<Integer> timeDatas = avgStationTimes.getOrDefault(tripKey, new ArrayList<>());
        timeDatas.add(t - passenger.inStationTime);
        avgStationTimes.put(tripKey, timeDatas);
        // 出站后，从站内容器中移除
        inStationMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String tripKey = startStation + "-" + endStation;
        if (!avgStationTimes.containsKey(tripKey)) {
            System.out.println("没有统计站点" + tripKey + "站点的数据，无法计算平均时间");
            return 0.0;
        }
        List<Integer> timeTotal = avgStationTimes.get(tripKey);
        Integer sumTime = timeTotal.stream().reduce(Integer::sum).orElse(0);
        return (double) sumTime / (double) timeTotal.size();
    }

    /**
     * 乘客实体类
     */
    public class Passenger {
        // 乘客ID
        Integer id;
        // 进站名称
        String startStation;
        // 进站时间点
        Integer inStationTime;

        public Passenger(Integer id, String startStation, Integer inStationTime) {
            this.id = id;
            this.startStation = startStation;
            this.inStationTime = inStationTime;
        }
    }

    public static void main(String[] args) {
        LeetCode1396设计地铁系统 test = new LeetCode1396设计地铁系统();
        test.checkIn(45,"Leyton",3);
        test.checkIn(32,"Paradise",8);
        test.checkIn(27,"Leyton",10);
        test.checkOut(45,"Waterloo",15);
        test.checkOut(27,"Waterloo",20);
        test.checkOut(32,"Cambridge",22);
        test.getAverageTime("Paradise","Cambridge");
        test.getAverageTime("Leyton","Waterloo");
        test.checkIn(10,"Leyton",24);
        test.getAverageTime("Leyton","Waterloo");
        test.checkOut(10,"Waterloo",38);
        test.getAverageTime("Leyton","Waterloo");
    }
}
