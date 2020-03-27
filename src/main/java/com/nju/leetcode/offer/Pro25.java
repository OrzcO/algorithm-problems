package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.ListNode;

public class Pro25 {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     * 0 <= 链表长度 <= 1000
     *
     * 归并排序的链表写法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ans.next = l1;
                ans = ans.next;
                l1 = l1.next;
            } else {
                ans.next = l2;
                ans = ans.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            ans.next = l1;
        }
        if (l2 != null) {
            ans.next = l2;
        }
        return cur.next;
    }
}
