package com.nju.leetcode.offer;

import org.junit.Test;

/**
 *
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 2 <= n <= 100000
 */

public class Pro3 {
    /**
     * solution 1
     * 基于hash的算法，但是需要一个O(n)的数组，T: O(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        boolean[] hash = new boolean[nums.length];
        for (int i : nums) {
            if (hash[i]) {
                return i;
            } else {
                hash[i] = true;
            }
        }
        return 0;
    }

    /**
     * 基于交换的hash的算法,空间 O(1)
     */
    public int findRepeatNumber1(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int temp;
        for(int i = 0; i < len; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                else{
                    temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber1(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}