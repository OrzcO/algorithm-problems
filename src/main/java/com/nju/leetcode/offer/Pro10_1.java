package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro10_1 {

    public int fib(int n) {
        int[] dp = new int[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 100; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    @Test
    public void test() {
        for (int i=0;i<=100;i++) {
            System.out.println( i + " : "  + fib(i));
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
