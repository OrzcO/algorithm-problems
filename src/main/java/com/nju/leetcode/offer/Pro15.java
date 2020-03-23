package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro15 {

    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
     * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     *
     * 示例 1：
     *
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     *
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     *
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     * @param n
     * @return
     */

    /**
     * solution 1: 由于是无符号数， n >>>= 1 ，然后 cnt += n & 1, return cnt
     * 统计每一位即可 O(n) n : n的二进制表示的位数
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n&1;
            n >>>= 1;
        }
        return cnt;
    }

    /**
     * O(n) : n 是 n的二进制表示中1的个数
     * 用 n& n-1 ，去掉了最后一个1， 然后递归调用 & 之后的值。
     * 但是对于 有符号的负数的效果不知道， 但是对于正数 | 0 是OK的。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int cur = n & (n-1);
        if (cur == 0) {
            return 1;
        } else {
//            return hammingWeight(cur) + hammingWeight(n - cur);
            return hammingWeight(cur) + 1;
        }
    }





    @Test
    public void test() {
//        System.out.println("11111111111111111111111111111101".length());
//        System.out.println(-12 >>> 1);
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
//        System.out.println(hammingWeight(11111111111111111111111111111101));
    }
}
