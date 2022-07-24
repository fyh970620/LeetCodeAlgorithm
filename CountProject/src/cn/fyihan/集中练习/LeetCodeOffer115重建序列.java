package com.lagou.exam;

import java.util.*;

public class LeetCodeOffer115重建序列 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        /* 问题：唯一性无法保证 优化不够全面 70/84 通过率83.3%
        boolean[] isExist = new boolean[nums.length];
        Map<Integer, Integer> idexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            idexMap.put(nums[i], i);
        }
        for (List<Integer> sequence : sequences) {
            int startIdex = -1;
            for (int i = 0; i < sequence.size(); i++) {
                Integer tempIdex = idexMap.getOrDefault(sequence.get(i), -1);
                if (tempIdex == -1 || tempIdex < startIdex) {
                    return false;
                }
                // 判断是否中间有false，如果有则不能直接放置true，可能有其它的排列组合
                boolean isConfirm = true;
                if (startIdex != -1 && tempIdex - startIdex != 1) {
                    for (int y = startIdex; y <= tempIdex; y++) {
                        if (!isExist[y]) {
                            // 说明该范围中还有内容的顺序没有确定，不能直接确定tempIdex为true
                            isConfirm = false;
                            break;
                        }
                    }
                }
                if (isConfirm) {
                    isExist[tempIdex] = true;
                }
                startIdex = tempIdex;
            }
        }
        for (int i = 0; i < isExist.length; i++) {
            if (!isExist[i]) {
                return false;
            }
        }
        return true;*/
        boolean[] isExist = new boolean[nums.length];
        isExist[0] = true;
        Map<Integer, Integer> idexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            idexMap.put(nums[i], i);
        }
        for (List<Integer> sequence : sequences) {
            // 题目已经给出sequence中的都是nums的子序列，不用多做判断
            int startIndex = idexMap.get(sequence.get(0));
            for (int i = 1; i < sequence.size(); i++) {
                int endIdex = idexMap.get(sequence.get(i));
                if (endIdex - startIndex == 1) {
                    isExist[endIdex] = true;
                    startIndex = endIdex;
                }
            }
        }
        for (int i = 0; i < isExist.length; i++) {
            if (!isExist[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCodeOffer115重建序列 test = new LeetCodeOffer115重建序列();
       /* List<Integer> list1 = Arrays.asList(1,2);
        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(list1);
        System.out.println(test.sequenceReconstruction(new int[]{1,2,3},list2));*/
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<List<Integer>> list3 = new ArrayList<>();
        list3.add(list1);
        list3.add(list2);
        System.out.println(test.sequenceReconstruction(new int[]{1, 2, 3}, list3));
    }
}
