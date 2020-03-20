package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro5 {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        int i=0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                ans.append("%20");
            } else {
                ans.append(s.charAt(i));
            }
            i++;
        }
        return ans.toString();
    }


    @Test
    public void test() {
        System.out.println(replaceSpace("We are happy."));
    }
}
