package com.nju.leetcode.offer;

import org.junit.Test;

import java.util.Arrays;

public class Pro33 {

    @Test
    public void test() {
//        int[] arr = new int[]{1,6,3,2,5};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 3)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 3, arr.length)));
        System.out.println(verifyPostorder(new int[]{1,6,3,2,5}));
        System.out.println(verifyPostorder(new int[]{1,3,2,6,5}));
        System.out.println(verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }

    /**
     * 递归方法进行解， [5, 4, 8, 9, 11, 12, 10, 7]
     * 首先找到最后一位pivot:7,然后找到第一个比pivot大的index,如果index之后都比pivot大，
     * 递归找这两个子数组
     * return [5, 4] && [8, 9, 11, 12, 10]
     * 否则直接返回错误，不符合后续遍历的规则。
     * len <= 2，无法判断了，直接返回true,因为他可能是一个后续遍历的树的形式(题意要求可能)
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2) {
            return true;
        }
        int len = postorder.length;
        int l = 0, pivot = postorder[len-1];
        while (l < len) {
            if (postorder[l] < pivot) {
                l++;
            } else {
                break;
            }
        }
        // check l ~ len-2 > pivot
        for (int i=l+1;i<len;i++) {
            if (postorder[i] < pivot) {
                return false;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, l))
                    && verifyPostorder(Arrays.copyOfRange(postorder, l, len-1));
    }


}
