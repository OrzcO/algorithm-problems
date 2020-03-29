package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *      * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 *      * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 *      * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *      * 示例 1：
 *      * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 *      * 输出：true
 *      * 数字不重复。
 */
public class Pro31 {
    /**
     *
     * 基于栈的解法，不停的压栈出栈进行解决
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length, i=0, j=0;
        while (j != len) {
            while ((stack.isEmpty() || stack.peek() != popped[j]) && i<=len-1) {
                stack.push(pushed[i++]);
            }
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else if (i == len) {
                return false;
            }
        }
        if (i == len) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

}
