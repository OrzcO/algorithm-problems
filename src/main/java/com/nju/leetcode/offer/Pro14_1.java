package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro14_1 {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     *
     * 2 <= n <= 58
     *
     *
     * solution : 贪心，尽量用3，然后用2来拼，应为5 : 3*2 > 5; 6 : 3*3 > 6
     * 尽量多用3来拼是一种能凑到最大值的策略
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int ans = 1;
//        2 => 1 , 3 => 2 题目特殊情况
        if (n <= 3) {
            return n-1;
        }
        while (n >= 2) {
            if (n >= 5 || n == 3) {
                ans *= 3;
                n -= 3;
            } else {
                ans *= 2;
                n -= 2;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(2)); // 1
        System.out.println(cuttingRope(3)); // 2
        System.out.println(cuttingRope(4));
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope(10));
    }
}
