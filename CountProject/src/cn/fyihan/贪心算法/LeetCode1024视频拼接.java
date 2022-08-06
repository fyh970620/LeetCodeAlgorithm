package com.lagou.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1024视频拼接 {
    private Map<Integer, List<Integer>> clipMap = new HashMap<>();

    public int videoStitching(int[][] clips, int time) {
        int maxTime = Integer.MIN_VALUE;
        for (int[] clip : clips) {
            List<Integer> nextSteps = clipMap.getOrDefault(clip[0], new ArrayList<>());
            maxTime = Math.max(maxTime, clip[1]);
            nextSteps.add(clip[1]);
            clipMap.put(clip[0], nextSteps);
        }
        // 不管如何，都应该从0开始
        if (!clipMap.containsKey(0) || maxTime < time) {
            return -1;
        }
        List<Integer> startSteps = clipMap.get(0);
        int minJump = Integer.MAX_VALUE;
        for (Integer nextStep : startSteps) {
            int compareJump = jumpSteps(1, 0, nextStep, time);
            if (compareJump == -1) {
                continue;
            }
            minJump = Math.min(minJump, compareJump);
        }
        if (minJump == Integer.MAX_VALUE) {
            return -1;
        }
        return minJump;
    }

    private Map<String, Integer> hasJumpMap = new HashMap<>();

    private int jumpSteps(int jumps, int lastStep, int currStep, int time) {
        if (currStep >= time) {
            return jumps;
        }
        // 从lastStep 与 currStep中开始找
        int minJumps = Integer.MAX_VALUE;
        for (int i = lastStep + 1; i <= currStep; i++) {
            if (clipMap.containsKey(i)) {
                List<Integer> nextSteps = clipMap.get(i);
                for (Integer nextStep : nextSteps) {
                    String jumpKey = i + "-" + nextStep;
                    int sumJump = 0;
                    if (hasJumpMap.containsKey(jumpKey)) {
                        sumJump = hasJumpMap.get(jumpKey);
                        if (sumJump == -1) {
                            continue;
                        }
                        sumJump += jumps;
                    } else {
                        sumJump = jumpSteps(jumps + 1, i, nextStep, time);
                        if (sumJump != -1) {
                            hasJumpMap.put(jumpKey, sumJump - jumps);
                        } else {
                            hasJumpMap.put(jumpKey, -1);
                        }
                    }
                    if (sumJump != -1) {
                        minJumps = Math.min(minJumps, sumJump);
                    }
                }
            }
        }
        if (minJumps == Integer.MAX_VALUE) {
            return -1;
        }
        return minJumps;
    }

    public static void main(String[] args) {
        LeetCode1024视频拼接 test = new LeetCode1024视频拼接();
        test.videoStitching(new int[][]{
                {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}
        }, 10);
    }
}
