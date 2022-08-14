package com.lagou.exam;

import java.util.HashMap;
import java.util.Map;

public class LeetCode781森林中的兔子 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> runAnswers = new HashMap<>();
        int minSum = 0;
        for (int answer : answers) {
            if (answer == 0) {
                minSum += 1;
                continue;
            }
            if (runAnswers.containsKey(answer)) {
                int count = runAnswers.get(answer) - 1;
                if (count == 0) {
                    runAnswers.remove(answer);
                } else {
                    runAnswers.put(answer, count);
                }
                continue;
            }
            minSum += answer + 1;
            runAnswers.put(answer, answer);
        }
        return minSum;
    }
}
