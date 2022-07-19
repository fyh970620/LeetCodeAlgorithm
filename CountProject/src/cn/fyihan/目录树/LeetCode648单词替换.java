package cn.fyihan.Ä¿Â¼Ê÷;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode648µ¥´ÊÌæ»» {
    private Map<Character, Integer> map = new HashMap<>();

    private void initMap() {
        int idex = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, idex++);
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        initMap();
        TreeNode[] rootNodes = new TreeNode[26];
        for (String dicStr : dictionary) {
            char startChar = dicStr.charAt(0);
            if (rootNodes[map.get(startChar)] == null) {
                rootNodes[map.get(startChar)] = new TreeNode();
            }
            TreeNode tempNode = rootNodes[map.get(startChar)];
            int index = 1;
            while (index < dicStr.length()) {
                int tempIdex = map.get(dicStr.charAt(index++));
                if (tempNode.treeNodes[tempIdex] == null) {
                    tempNode.treeNodes[tempIdex] = new TreeNode();
                }
                tempNode = tempNode.treeNodes[tempIdex];
            }
            tempNode.isEnd = true;
        }
        String[] strs = sentence.split(" ");
        String[] res = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String originStr = strs[i];
            char oriChar = originStr.charAt(0);
            TreeNode tempNode = rootNodes[map.get(oriChar)];
            if (tempNode == null) {
                res[i] = originStr;
                continue;
            }
            int index = 1;
            while (true) {
                if (tempNode.isEnd) {
                    // ×î¶Ì
                    res[i] = originStr.substring(0, index);
                    break;
                }
                if (index == originStr.length()) {
                    if (!tempNode.isEnd) {
                        res[i] = originStr;
                    }
                    break;
                }
                char tempChar = originStr.charAt(index);
                TreeNode node = tempNode.treeNodes[map.get(tempChar)];
                if (node == null) {
                    res[i] = originStr;
                    break;
                }
                tempNode = node;
                index++;
            }
        }
        return String.join(" ", res);
    }

    class TreeNode {
        TreeNode[] treeNodes;

        Boolean isEnd;

        public TreeNode() {
            this.treeNodes = new TreeNode[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        LeetCode648µ¥´ÊÌæ»» test = new LeetCode648µ¥´ÊÌæ»»();
        test.replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");
    }
}
