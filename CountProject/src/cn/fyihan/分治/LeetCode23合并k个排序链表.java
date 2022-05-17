package cn.fyihan.分治;

public class LeetCode23合并k个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
       return mergeListNode(lists, 0, lists.length-1);
    }

    private ListNode mergeListNode(ListNode[] originLists, int start, int end) {
        if (start == end) {
            return originLists[start];
        }
        int mid = (start + end )/ 2;
        ListNode rListNode = mergeListNode(originLists, mid+1, end);
        ListNode lListNode = mergeListNode(originLists, start, mid);
        return mergeListNodeDetail(rListNode, lListNode);
    }

    private ListNode mergeListNodeDetail(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        if (l1.val > l2.val ) {
            l2.next = mergeListNodeDetail(l2.next, l1);
            return l2;
        } else {
            l1.next = mergeListNodeDetail(l1.next, l2);
            return l1;
        }
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
