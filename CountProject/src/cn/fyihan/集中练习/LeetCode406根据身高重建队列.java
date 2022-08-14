package com.lagou.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        List<int[]> rtRes = new ArrayList<>(people.length);
        for (int[] eachPerson : people) {
            if (rtRes.size() - 1 >= eachPerson[1]) {
                rtRes.add(eachPerson[1], eachPerson);
                continue;
            }
            rtRes.add(eachPerson);
        }
        return (int[][]) rtRes.toArray(new int[people.length][]);
    }
}
