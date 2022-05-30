package cn.fyihan.集中练习;


import java.util.List;

public class LeetCode2两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rtNode = null;
        int intoSystem = 0;
        while (true) {
            if (l1==null && l2==null) {
                break;
            }
            int num1 = l1 == null? 0: l1.val;
            int num2 = l2 == null? 0: l2.val;
            int sum = num1 + num2 + intoSystem;
            
            if (rtNode == null) {
                rtNode = new ListNode(sum % 10);
            } else {
                rtNode.next = new ListNode(sum%10);
                rtNode = rtNode.next;
            }
            // 进位数
            intoSystem = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (intoSystem > 0) {
            rtNode.next = new ListNode(intoSystem);
        }
        return rtNode;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
