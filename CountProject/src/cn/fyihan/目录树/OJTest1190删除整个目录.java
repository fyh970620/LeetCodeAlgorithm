package cn.fyihan.Ŀ¼��;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class OJTest1190ɾ������Ŀ¼ {
    private Set<String> containDic = new HashSet<>();

    private TreeNode treeNode;

    private static String delAllDirectorys(String[] dirTreeLines) {
        // ����
        OJTest1190ɾ������Ŀ¼ test = new OJTest1190ɾ������Ŀ¼();
        test.buildTree(dirTreeLines, 0);
        // ������
        String rtRes = test.parseTree(test.treeNode, "");
        return rtRes.substring(0, rtRes.length() - 1);
    }

    private String parseTree(TreeNode parseNode, String res) {
        if (parseNode.nodes == null || parseNode.nodes.size() == 0) {
            res += parseNode.value + " ";
            return res;
        }
        // �ӽڵ�
        List<TreeNode> cNodes = parseNode.nodes;
        for (TreeNode node : cNodes) {
            res = parseTree(node, res);
        }
        res += parseNode.value + " ";
        return res;
    }

    private void buildTree(String[] dirTreeLines, int dept) {
        TreeNode dicTreeNode = null;
        for (String treeLine : dirTreeLines) {
            if (treeLine.indexOf("|-") == -1 && treeNode == null) {
                // ���ڵ�
                treeNode = new TreeNode(dept, treeLine);
                dicTreeNode = treeNode;
            }
            if (treeLine.indexOf("|-") >= 0 && dicTreeNode != null) {
                int currDept = (treeLine.lastIndexOf("|-") + 2) / 2;
                String value = treeLine.substring(treeLine.lastIndexOf("|-") + 2);
                TreeNode curTreeNode = new TreeNode(currDept, value);
                if (dicTreeNode.dept == currDept || currDept < dicTreeNode.dept) {
                    while (currDept != dicTreeNode.dept) {
                        dicTreeNode = dicTreeNode.pNode;
                    }
                    curTreeNode.pNode = dicTreeNode.pNode;
                    if (containDic.contains(value + "-" + currDept + "-" + curTreeNode.pNode.value)) {
                        continue;
                    }
                    dicTreeNode.pNode.nodes.add(curTreeNode);
                } else if (currDept - dicTreeNode.dept == 1) {
                    curTreeNode.pNode = dicTreeNode;
                    if (containDic.contains(value + "-" + currDept + "-" + curTreeNode.pNode.value)) {
                        continue;
                    }
                    dicTreeNode.nodes.add(curTreeNode);
                } else {
                    continue;
                }
                containDic.add(value + "-" + currDept + "-" + curTreeNode.pNode.value);
                dicTreeNode = curTreeNode;
            }
        }
    }

    class TreeNode {
        TreeNode pNode;
        // ���
        int dept;
        // ����
        String value;
        // �ڵ���Ŀ
        List<TreeNode> nodes;

        public TreeNode(int dept, String value) {
            this.dept = dept;
            this.value = value;
            nodes = new ArrayList<>();
        }
    }

    // main�����OJƽ̨����
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(sc.nextLine());
        String[] dirTreeLines = new String[line];
        for (int i = 0; i < line; i++) {
            dirTreeLines[i] = sc.nextLine();
        }
        sc.close();*/
        String[] dirTreeLines = new String[]{
                "A",
                "|-B",
                "|-|-C",
                "|-|-|-|-C",
                "|-|-B",
                "|-|-|-B",
                "|-|-C",
                "|-B"
        };

        // ���ÿ���ʵ�ֵĴ����ȡ���
        String delDirs = delAllDirectorys(dirTreeLines);
        System.out.println(delDirs);
    }
}
