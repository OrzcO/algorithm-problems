package com.nju.leetcode.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Pro30 {

}

// 不是最优化的做法，每次pop都进行两次stack.pop
//class MinStack {
//
//    Stack<Integer> data;
//    Stack<Integer> min;
//
//    public MinStack() {
//        data = new Stack<>();
//        min = new Stack<>();
//    }
//
//    public void push(int x) {
//        data.push(x);
//        if (min.isEmpty()) {
//            min.add(x);
//        } else {
//            int cur = min.peek();
//            if (x <= cur) {
//                min.push(x);
//            } else {
//                min.push(cur);
//            }
//        }
//    }
//
//    public void pop() {
//        data.pop();
//        min.pop();
//    }
//
//    public int top() {
//        return data.peek();
//    }
//
//    public int min() {
//        return min.peek();
//    }
//}

class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (data.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}