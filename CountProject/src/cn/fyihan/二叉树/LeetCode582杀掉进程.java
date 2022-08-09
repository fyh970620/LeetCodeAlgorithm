package com.lagou.exam;

import java.util.*;

public class LeetCode582杀掉进程 {
    private Map<Integer, List<Integer>> pmap = new HashMap<>();

    private Set<Integer> set = new HashSet<Integer>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = pmap.getOrDefault(ppid.get(i), new ArrayList<>());
            list.add(i);
            pmap.put(ppid.get(i), list);
        }
        int rootIdex = pmap.get(0).get(0);
        if (pid.get(rootIdex) == kill) {
            return pid;
        }
        killProcessDetail(pid, kill);
        return new ArrayList<>(set);
    }

    private void killProcessDetail(List<Integer> pid, int kill) {
        List<Integer> idexs = pmap.get(kill);
        set.add(kill);
        if (idexs == null || idexs.size() == 0) {
            return;
        }
        for (int idex : idexs) {
            killProcessDetail(pid, pid.get(idex));
        }
    }

    public static void main(String[] args) {
        LeetCode582杀掉进程 test = new LeetCode582杀掉进程();
        test.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5);
    }
}
