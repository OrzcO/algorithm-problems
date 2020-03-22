package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro13 {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     *
     * 思路错了，如果是求m*n的矩阵中，所有满足情况的，而不是一步一步搜索的，那么这种做法是对的
     * 而且可以用dp来优化下最后相乘的效率。
     * @param m
     * @param n
     * @param k
     * @return
     */
//    public int movingCount(int m, int n, int k) {
//        int ans = 0;
//        int r=0,c=0;
//        int[] row = new int[19];
//        int[] col = new int[19];
//        for (int i=0;i<m;i++) {
//            int cnt = 0;
//            int cur = i;
//            while (cur != 0) {
//                cnt += cur % 10;
//                cur /= 10;
//            }
//            r = Math.max(r, cnt + cur);
//            row[cnt + cur] ++;
//        }
//        for (int i=0;i<n;i++) {
//            int cnt = 0;
//            int cur = i;
//            while (cur != 10) {
//                cnt += cur % 10;
//                cur /= 10;
//            }
//            c = Math.max(c, cnt + cur);
//            col[cnt + cur] ++;
//        }
//        for (int i=0;i<=k&&i<=r;i++) {
//            for (int j=0;j<=k-i&&j<=c;j++) {
//                ans += row[i] * col[j];
//            }
//        }
//        return ans;
//    }

    boolean[][] visit;
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        visit = new boolean[m][n];
        int ans = dfs(0, 0, m, n, k);
        return ans;
    }

    public int dfs(int i, int j, int m, int n, int k) {
        if (i >= m || j >= n || i < 0 || j < 0) {
            return 0;
        }
        if (cal(i, j) <= k && !visit[i][j]) {
            visit[i][j] = true;
//            下一行可以不往上和往左走
            return 1 + dfs(i-1, j, m, n, k) + dfs(i, j-1, m, n, k)
                    + dfs(i+1, j, m, n, k) + dfs(i, j+1, m, n, k);
        }
        return 0;
    }

    public int cal(int m, int n) {
        int cnt = 0;
        while (m != 0) {
            cnt += m%10;
            m /= 10;
        }
        while (n != 0) {
            cnt += n%10;
            n /= 10;
        }
        return cnt ;
    }


    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 1)); // 3
        System.out.println(movingCount(3, 1, 0)); // 1
        System.out.println(movingCount(1, 2, 1)); // 2
        System.out.println(movingCount(16, 8, 4)); // 15
        System.out.println(movingCount(38, 15, 9)); // 135
    }
}
