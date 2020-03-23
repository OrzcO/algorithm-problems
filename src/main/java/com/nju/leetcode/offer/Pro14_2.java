package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro14_2 {

    /**
     * 不能用Math.pow进行简化，而且2147483647 < 1000000007 * 3 ，会溢出
     * 所以只能用long
     *n
     * @param
     */

    public int cuttingRope(int n) {
        int mod = 1000000007;
        long ans = 1;
//        2 => 1 , 3 => 2 题目特殊情况
        if (n <= 3) {
            return n-1;
        }
        while (n >= 2) {
            if (n >= 5 || n == 3) {
                ans *= 3;
                ans %= mod;
                n -= 3;
            } else {
                ans *= 2;
                ans %= mod;
                n -= 2;
            }
        }
        return (int) ans;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(1000));
    }

}
