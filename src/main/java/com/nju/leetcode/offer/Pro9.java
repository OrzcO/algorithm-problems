package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Stack;

public class Pro9 {

    /**
     *
     * 两个栈实现一个队列
     *
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    @Test
    public void test() {
        CQueue queue = new CQueue();
//        queue.appendTail(3);
//        System.out.println(queue.deleteHead());
//        System.out.println(queue.deleteHead());

        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    class CQueue {

        Stack<Integer> push ;
        Stack<Integer> pop ;

        public CQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void appendTail(int value) {
            push.add(value);
        }

        public int deleteHead() {
            if (!pop.isEmpty()) {
                return pop.pop();
            } else {
                if (push.isEmpty()) {
                    return -1;
                }
                while (!push.isEmpty()) {
                    pop.add(push.pop());
                }
                return pop.pop();
            }
        }
    }

}
