package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Arrays;

public class Pro17 {

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3
     * 一直到最大的 3 位数 999。
     *
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        if (n == 0) {
            return null;
        }
        int size = (int) (Math.pow(10, n)-1);
        int[] ans = new int[size];
        for (int i=0;i<size;i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(printNumbers(0)));
        System.out.println(Arrays.toString(printNumbers(1)));
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}
