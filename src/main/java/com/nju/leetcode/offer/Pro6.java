package com.nju.leetcode.offer;

import com.nju.leetcode.datastructure.ListNode;

import java.util.Stack;

/**
 * solution :
 * 1. 遍历两遍，第一遍遍历链表获取len，然后从后往前插入[]，再遍历一遍链表
 * 2. 采用递归函数来实现类似栈的插入一个ArrayList[],再遍历一次ArrayList返回[]
 * 3. 采用stack的方式
 */
public class Pro6 {

    /**
     *
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * 基于栈的实现
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] ans;
        if (stack.size() == 0) {
            return new int[]{};
        } else {
            ans = new int[stack.size()];
        }
        int i=0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
