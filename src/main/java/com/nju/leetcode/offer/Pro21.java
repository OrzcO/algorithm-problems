package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Pro21 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
     * 所有偶数位于数组的后半部分。
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0 , j = nums.length-1;
        while (i < j) {
            while (i <= nums.length-1 && (nums[i]&1) == 1) {
                i++;
            }
            while (j >= 0 && (nums[j]&1) == 0) {
                j--;
            }
            if (i < j) {
                int cur = nums[i];
                nums[i] = nums[j];
                nums[j] = cur;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        Random random = new Random(1000);
        int n = 30;
        while (n-- > 0) {
            int N = 20;
            int[] arr = new int[N];
            for (int i=0;i<N;i++) {
                arr[i] = random.nextInt(100);
            }
            System.out.println("=============");
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(exchange(arr)));
            System.out.println("=============");
        }
    }
}
