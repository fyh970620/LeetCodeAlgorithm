package cn.fyihan.exam;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode共享单车管理系统 {

    private Map<Integer, Node> stationMap;

    private Integer capacity;

    public static void main(String[] args) {
        int[] preNode = {-1, 0, 1, 1, 5, 0, 1, 0};
        int capacity = 41;
        LeetCode共享单车管理系统 bikeManager = new LeetCode共享单车管理系统(preNode, capacity);
        bikeManager.printNodes();
        System.out.println("********BikeManager********");
        System.out.println("********rentBikes********");
        System.out.println(bikeManager.rentBikes(2, 31));
        System.out.println("********rentBikes********");
        System.out.println(bikeManager.rentBikes(3, 45));
        System.out.println("********getTop5Nodes********");
        System.out.println(Arrays.toString(bikeManager.getTop5Nodes()));
        bikeManager.printNodes();
        System.out.println("********returnBikes********");
        System.out.println(bikeManager.returnBikes(5, 29));
        System.out.println("********rentBikes********");
        System.out.println(bikeManager.rentBikes(5, 100));
        System.out.println("********reset********");
        System.out.println(bikeManager.reset());
        System.out.println("********rentBikes********");
        System.out.println(bikeManager.rentBikes(3, 12));
        System.out.println("********getTop5Nodes********");
        System.out.println(Arrays.toString(bikeManager.getTop5Nodes()));
        bikeManager.printNodes();
        bikeManager.printNodes();
        System.out.println("********end********");
    }

    public LeetCode共享单车管理系统(int[] preNode, int capacity) {
        this.stationMap = new HashMap<>();
        this.capacity = capacity;
        for (int i = 1; i < preNode.length; i++) {
            // key 站点
            stationMap.put(i, new Node(i, preNode[i], capacity / 2));
        }
    }

    // 借车
    public int rentBikes(int nodeId, int num) {
        if (!stationMap.containsKey(nodeId)) {
            return -1;
        }
        Node node = stationMap.get(nodeId);
        if (node.count < num) {
            node.count = 0;
            // 递归向父节点借车
            rentBikes(node.preStation, num - node.count);
            return 0;
        }
        return node.count = node.count - num;
    }

    public int returnBikes(int nodeId, int num) {
        if (!stationMap.containsKey(nodeId)) {
            return -1;
        }
        Node node = stationMap.get(nodeId);
        if (node.count + num > capacity) {
            node.count = capacity;
            // 递归向父类还车
            returnBikes(node.preStation, num - (capacity - node.count));
            return capacity;
        }
        return node.count = node.count + num;
    }

    public int reset() {
        int resetCount = 0;
        for (Node node : stationMap.values()) {
            if (node.count == 0 ||  node.count == capacity) {
                node.count = capacity / 2;
                resetCount ++;
            }
        }
        return resetCount;
    }

    public int[] getTop5Nodes() {
        List<Node> top5Nodes = stationMap.values().stream()
                        .sorted(Comparator.comparing(Node::getCount).reversed())
                        .limit(5).collect(Collectors.toList());
        return top5Nodes.stream().mapToInt(Node::getNowStation).toArray();
    }


    public class Node {
        // 当前站点ID
        int nowStation;
        // 父节点站点ID
        int preStation;
        // 单车数量
        int count;

        public Node(int nowStation, int preStation, int count){
            this.nowStation = nowStation;
            this.preStation = preStation;
            this.count = count;
        }

        public int getNowStation(){
            return this.nowStation;
        }

        public int getCount(){
            return this.count;
        }
    }

    public void printNodes() {
        System.out.println("print nodes");
        for (Node node : stationMap.values()) {
            System.out.println(node.nowStation + "," + node.preStation + "," + node.count);
        }
    }

}
