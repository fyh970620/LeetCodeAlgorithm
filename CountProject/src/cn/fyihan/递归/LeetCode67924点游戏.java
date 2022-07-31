package com.lagou.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode67924点游戏 {
    private Set<String> operationType = new HashSet<>();

    private final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        if (cards.length == 0) {
            return false;
        }
        injectOperationType();
        // 因为除法为实数的除法，所以使用double类型
        List<Double> doubleCards = new ArrayList<>();
        for (int card : cards) {
            doubleCards.add((double)card);
        }
        return solve(doubleCards);
    }

    private boolean solve(List<Double> doubleCards) {
        if (doubleCards.size() == 1) {
            return Math.abs(doubleCards.get(0) - 24) < EPSILON;
        }
        for (int i = 0; i<doubleCards.size(); i++) {
            for (int j =0; j<doubleCards.size(); j++) {
                if (i != j) {
                    List<Double> newCards = new ArrayList<>();
                    for (int k = 0; k<doubleCards.size(); k++) {
                        if (k != j && k!= i) {
                            newCards.add(doubleCards.get(k));
                        }
                    }
                    //对前面选出的两位进行计算
                    for(String operationType : operationType) {
                        // 加与乘运算无关位置摆放
                        if (i > j &&
                                ("ADD".equals(operationType) || "MULTIPLY".equals(operationType))) {
                            continue;
                        }
                        switch (operationType) {
                            case "ADD" :
                                newCards.add(doubleCards.get(i) + doubleCards.get(j));
                                break;
                            case "MULTIPLY" :
                                newCards.add(doubleCards.get(i) * doubleCards.get(j));
                                break;
                            case "SUBTRACT" :
                                newCards.add(doubleCards.get(i) - doubleCards.get(j));
                                break;
                            case "DIVIDE" :
                                if (Math.abs(doubleCards.get(j)) < EPSILON) {
                                    continue;
                                } else {
                                    newCards.add(doubleCards.get(i) / doubleCards.get(j));
                                    break;
                                }
                        }
                        if (solve(newCards)) {
                            return true;
                        }
                        newCards.remove(newCards.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private void injectOperationType() {
        // 加
        operationType.add("ADD");
        // 乘
        operationType.add("MULTIPLY");
        // 减
        operationType.add("SUBTRACT");
        // 除
        operationType.add("DIVIDE");
    }
}
