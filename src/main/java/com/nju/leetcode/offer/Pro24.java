package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.ListNode;

public class Pro24 {

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 限制：
     * 0 <= 节点个数 <= 5000
     *
     * 3个变量进行链表逆序操作
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode next = null;
        while (cur != null) {
            if (pre == head) {
                pre.next = null;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
