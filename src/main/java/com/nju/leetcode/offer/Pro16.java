package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro16 {
    /**
     * 实现函数double Power(double base, int exponent)，
     * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     *
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000

     * 示例 2:
     * 输入: 2.10000, 3
     * 输出: 9.26100

     * 示例 3:
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     */

    /**
     * 注意对底数为0，1，-1进行优化
     * O(n) 会超时
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = true;
        double ans = 1;
        flag = n > 0 ? true : false;
        if (x == 1.0) {
            return x;
        } else if (x == 0.0) {
            return 0;
        } else if (x == -1.0) {
            return Math.abs(n) % 2 == 0 ? -1.0 : 1.0;
        }
        n = Math.abs(n);
        while (n-- > 0) {
            ans *= x;
        }
        return flag ? ans : 1.0 / ans;
    }

    /**
     * 快速幂 O(logn)
     * int : [-2147483648, 2147483647] ,所以用java默认的int操作，-1 * -2147483648会溢出
     * 所以要用一个long 来存储，好坑。。。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans = 1.0;
        long b = n;
        if (n < 0) {
            b = -b;
            x = 1/x;
        }
        double cur = x;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans *= cur;
            }
            b >>= 1;
            cur *= cur;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.00000, 10) + " : " + Math.pow(2.00000, 10));
        System.out.println(myPow(2.10000, 3) + " : " + Math.pow(2.10000, 3));
        System.out.println(myPow(2.00000, -2) + " : " + Math.pow(2.00000, -2));
        System.out.println(myPow(0.00001, 2147483647) + " : " + Math.pow(0.00001, 2147483647));
    }
}
