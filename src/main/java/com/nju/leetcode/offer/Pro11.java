package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro11 {


    public int minArray(int[] numbers) {
        int min = numbers.length == 0 ? 0 : numbers[0];
        for (int i=1;i<numbers.length;i++) {
            if (numbers[i] < numbers[i-1]) {
                min = numbers[i];
                break;
            }
        }
        return min;
    }
    @Test
    public void test () {
        System.out.println(minArray(new int[]{3,4,5,1,2}));
        System.out.println(minArray(new int[]{2,2,2,0,1}));
    }
}
