package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Arrays;

public class Pro29 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * 限制：
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     *
     * 递归，比较考验策略的实现，以及code
     * @param matrix
     * @return
     */
    int[] ans;
    int cnt = 0;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        ans = new int[matrix.length * matrix[0].length];
        cnt = 0;
        traverse(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
        return ans;
    }


    public void traverse(int[][] matrix, int i0, int j0, int i1, int j1) {
        if (i0 == i1) {
            for (int j=j0;j<=j1;j++) {
                ans[cnt++] = matrix[i0][j];
            }
            return;
        }
        if (j0 == j1) {
            for (int i=i0;i<=i1;i++) {
                ans[cnt++] = matrix[i][j0];
            }
            return;
        }
        for (int j=j0;j<=j1-1;j++) {
            ans[cnt++] = matrix[i0][j];
        }
        for (int i=i0;i<=i1-1;i++) {
            ans[cnt++] = matrix[i][j1];
        }
        for (int j=j1;j>=j0+1;j--) {
            ans[cnt++] = matrix[i1][j];
        }
        for (int i=i1;i>=i0+1;i--) {
            ans[cnt++] = matrix[i][j0];
        }

        if (i0+1 <= i1-1 && j0+1 <= j1-1) {
            traverse(matrix, i0+1, j0+1, i1-1, j1-1);
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(spiralOrder(new int[][]
                {{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]
                {{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]
                {{1,2,3,4}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]
                {{1},{2},{3},{4}})));
    }
}
