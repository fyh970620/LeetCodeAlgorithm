package cn.fyihan.exam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCodeExcel数据表格区域统计 {

    private static Map<String, Integer> dicMap;

    private int[][] table;

    private List<WaitCountNode> nodes = new ArrayList<>();

    public static void main(String[] args) {
        LeetCodeExcel数据表格区域统计 test = new LeetCodeExcel数据表格区域统计();
        // 初始化操作
        test.initList(5,3);
        // 数据输入
        test.printIntoList(Arrays.asList("10", "12", "=C5"), 0);
        test.printIntoList(Arrays.asList("15", "5", "6"), 1);
        test.printIntoList(Arrays.asList("7", "8", "=3+C2"), 2);
        test.printIntoList(Arrays.asList("6", "=B2-A1", "=C2"), 3);
        test.printIntoList(Arrays.asList("7", "5", "3"), 4);
        // 计算待计算数据
        test.injectDataToTable();
        // 计算矩形的和 A1:C1
        int scopeNum = test.countScope("A1:C1");
    }

    /**
     * 范围求和
     *
     * @param requestStr 请求待处理字符串
     * @return 计算和
     */
    public int countScope(String requestStr) {
        String[] reqParam = requestStr.split(":");
        // 字典中取坐标
        int startCol = dicMap.get(reqParam[0].substring(0,1));
        int startRow = Integer.parseInt(reqParam[0].substring(1)) -1;
        int endCol = dicMap.get(reqParam[1].substring(0,1));
        int endRow = Integer.parseInt(reqParam[1].substring(1)) -1;
        int rtRes = 0;
        for (int i= startCol; i<=endCol; i++) {
            for (int y=startRow; y<=endRow; y++) {
                rtRes += table[y][i];
            }
        }
        return rtRes;
    }

    /**
     * 把待计算数据计算后存入到table中去
     */
    public void injectDataToTable() {
        if (nodes.size() == 0) {
            return;
        }
        for (WaitCountNode node : nodes) {
            int num = countPrintStr(node.message);
            table[node.row][node.col] = num;
        }
    }

    /**
     * 传入的数据初始化表格面板
     *
     * @param printNum 输入内容
     * @param row 行数
     */
    public void printIntoList(List<String> printNum, int row) {
        for (int i=0; i<printNum.size(); i++) {
            String print = printNum.get(i);
            if (!print.contains("=")) {
                table[row][i] = Integer.parseInt(print);
                continue;
            }
            nodes.add(new WaitCountNode(row, i, print));
        }
    }

    /**
     * 计算具体的内容为数字
     *
     * @param printStr
     * @return
     */
    private int countPrintStr(String printStr) {
        char[] chars = printStr.toCharArray();
        // 计算内容存储容器
        List<Integer> printNumstr = new ArrayList<Integer>();
        // 计算符号存储容器
        List<String> printParam = new ArrayList<String>();
        String res = "";
        for (char c : chars) {
            if (c == '+' || c == '-') {
                printNumstr.add(transferStrToNum(res));
                printParam.add(c + "");
                // 还原操作
                res = "";
                continue;
            }
            res += c;
        }
        int finalRes = printNumstr.get(0);
        for (int i=0; i < printParam.size(); i++) {
            if (printParam.get(i).equals("\\+")) {
                finalRes += printNumstr.get(i + 1);
                continue;
            }
            finalRes -= printNumstr.get(i + 1);
        }
        return finalRes;
    }

    /**
     * 符号转换成整型数字
     * @param printParam 转换字符内容
     * @return 整型数字
     */
    private int transferStrToNum(String printParam) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(printParam);
        if (matcher.find()) {
            // 包含 A-Z
            int col = dicMap.get(printParam.substring(0,1));
            int row =  Integer.parseInt(printParam.substring(1)) - 1;
            return table[row][col];
        }
        return Integer.parseInt(printParam);
    }

    /**
     * 初始化表格
     *
     * @param row 行
     * @param col 列
     * @return 表格数组
     */
    public void initList(int row, int col) {
        table =  new int[row][col];
        initDic();
    }

    /**
     * 字典表初始化
     */
    public void initDic() {
        dicMap = new HashMap<>();
        int index = 0;
        for (char i = 'A' ; i <= 'Z'; i++) {
            dicMap.put(i+"", index);
        }
    }

    /**
     * 待计算的实例
     */
    public class WaitCountNode {
        // 行坐标
        int row;

        // 列坐标
        int col;

        // 待计算内容
        String message;

        public WaitCountNode(int row, int col, String message){
            this.row = row;
            this.col = col;
            this.message = message;
        }
    }
}
