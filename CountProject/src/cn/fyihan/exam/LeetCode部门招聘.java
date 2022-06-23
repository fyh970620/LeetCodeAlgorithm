package cn.fyihan.exam;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode部门招聘 {
    private boolean[] isEmployee = new boolean[6];

    private List<List<Integer>> employRes;

    public static void main(String[] args) {
        LeetCode部门招聘 test = new LeetCode部门招聘();
        test.test();
    }

    public void test() {
        List<Deptpartment> depts = new ArrayList<>(2);
        depts.add(new Deptpartment(2, 130, 120));
        depts.add(new Deptpartment(1, 150, 150));
        employRes = new ArrayList<>();
        System.out.println("=====>dept初始化：" + depts.toString());
        List<Candidate> candidates = new ArrayList<>(6);
        candidates.add(new Candidate(0, 150, 100));
        candidates.add(new Candidate(1, 160, 190));
        candidates.add(new Candidate(2, 150, 200));
        candidates.add(new Candidate(3, 200, 190));
        candidates.add(new Candidate(4, 160, 190));
        candidates.add(new Candidate(5, 160, 190));
        System.out.println("===============================常规招聘开始================================");
        int totalCandidates = 6;
        // 首先对候选人进行排序
        List<Candidate> sortCandidates =  sortedByTeleCore(candidates);
        System.out.println("=====>candidates初始化：" + candidates);
        System.out.println("=====>candidates排序后：" + sortCandidates);
        while (true) {
            // 上一轮开始时，剩余的候选人
            int lastPiece = totalCandidates;
            if (lastPiece == 0) {
                break;
            }
            // 部门轮询招人
            for (int i = 0; i < depts.size(); i++) {
                int employId = employCandidates(depts.get(i), sortCandidates);
                if (employId == -1) {
                    // 没有招到
                    continue;
                }
                if (employRes.size() == depts.size()) {
                    employRes.get(i).add(employId);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(employId);
                    employRes.add(list);
                }
                isEmployee[employId] = true;
                totalCandidates --;
            }
            // 上一轮和本轮招聘结束后人数一样，则证明没有可招，跳出循环
            if (lastPiece == totalCandidates) {
                break;
            }
        }
        // 补录
        for (int i = 0; i < depts.size(); i++) {
            int lastIndex = employRes.get(i).size() - 1;
            int lastEmployId = employRes.get(i).get(lastIndex);
            int supportId = supplementEmploy(depts.get(i),candidates.get(lastEmployId),sortCandidates);
            if (supportId == -1) {
                continue;
            }
            if (employRes.get(i).size() == depts.size()) {
                employRes.get(i).add(supportId);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(supportId);
                employRes.add(list);
            }
            isEmployee[supportId] = true;
        }
        System.out.println("招聘结束，招聘结果===》  " + employRes);
    }

    /**
     * 根据技面分数排序(降序)
     *
     * @param candidates 候选人
     * @return 排序后的候选人名单
     */
    private List<Candidate> sortedByTeleCore(List<Candidate> candidates) {
        List<Candidate> sortCandidates = new ArrayList<>(candidates);
        Collections.sort(sortCandidates, new CandidateCompator());
        System.out.println("====> after sort, candidates show : /n" + sortCandidates);
        return sortCandidates;
    }

    /**
     * （常规录取）根据部门要求从有序候选人中录用
     *
     * @param deptpartment 用人部门对象
     * @param candidates 候选人名单(已排序)
     * @return 录用候选人ID
     */
    private Integer employCandidates(Deptpartment deptpartment, List<Candidate> candidates) {
        if ((deptpartment.employNum == deptpartment.targetNum)
                || candidates.size() == 0) {
            // 已经招满直接返回
            return -1;
        }
        // 因为已经完成排序，直接获取过滤后的candidates中的第一人
        deptpartment.employNum += 1;
        List<Candidate> conformEmploy = candidates.stream()
                .filter(candidate -> candidate.telcongyCore >= deptpartment.minTeleCore
                        && candidate.computerCore >= deptpartment.minComputerCore
                        && !isEmployee[candidate.id]).limit(1).collect(Collectors.toList());
        if (conformEmploy == null || conformEmploy.size() == 0) {
            // 没有符合规则的
            return -1;
        }
        int employId = conformEmploy.get(0).id;
        isEmployee[employId] = true;
        return employId;
    }

    /**
     * 补录
     *
     * @param deptpartment 用人部门对象
     * @param candidates 候选人名单(已排序)
     * @return 补录候选人ID
     */
    private Integer supplementEmploy(Deptpartment deptpartment, Candidate lastCandidates, List<Candidate> candidates) {
        if (candidates.size() == 0) {
            // 无候选名单无法继续招聘
            return -1;
        }
        List<Candidate> conformEmploy = candidates.stream()
                .filter(candidate -> candidate.telcongyCore >= deptpartment.minTeleCore
                        && candidate.computerCore >= deptpartment.minComputerCore
                        && lastCandidates.computerCore == candidate.computerCore
                        && lastCandidates.telcongyCore == candidate.telcongyCore
                        &&  !isEmployee[candidate.id]).limit(1).collect(Collectors.toList());
        if (conformEmploy == null || conformEmploy.size() == 0) {
            return -1;
        }
        return conformEmploy.get(0).id;
    }

    /**
     * 部门实例
     */
    public class Deptpartment {
        // 目标招聘人数
        int targetNum;

        // 机考最低分
        int minComputerCore;

        // 技面最低分
        int minTeleCore;

        // 已经招聘人数量
        int employNum;

        public Deptpartment(int targetNum, int minComputerCore, int minTeleCore) {
            this.targetNum = targetNum;
            this.minComputerCore = minComputerCore;
            this.minTeleCore = minTeleCore;
            this.employNum = 0;
        }
    }

    /**
     * 候选人实例
     */
    public class Candidate {
        // 候选人编号
        int id;

        // 机考分数
        int computerCore;

        // 技术面分数
        int telcongyCore;

        public Candidate(int id, int computerCore, int telcongyCore) {
            this.id = id;
            this.computerCore = computerCore;
            this.telcongyCore = telcongyCore;
        }

        public int getTelcongyCore(){
            return this.telcongyCore;
        }
    }

    /**
     * 候选人排序比较策略
     */
    public class CandidateCompator implements Comparator<Candidate> {

        @Override
        public int compare(Candidate o1, Candidate o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            if (o1.telcongyCore < o2.telcongyCore) {
                return 1;
            }
            if ((o1.telcongyCore == o2.telcongyCore)) {
                if (o1.computerCore < o2.computerCore) {
                    return 1;
                }
                if ((o1.computerCore == o2.computerCore) && (o1.id > o2.id)) {
                    return 1;
                }
            }
            return -1;
        }
    }
}
