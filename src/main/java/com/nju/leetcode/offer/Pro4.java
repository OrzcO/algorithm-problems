package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro4 {

    /**
     * 从右上角或者左下角查找即可 O(m+n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int len1 = matrix.length;
        if (len1 == 0) {
            return false;
        }
        int len2 = matrix[0].length;
        int i = 0, j = len2 - 1;
        while (i < len1 && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(findNumberIn2DArray(new int[][]
                {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5));
        System.out.println(findNumberIn2DArray(new int[][]
                {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 20));
    }
}
