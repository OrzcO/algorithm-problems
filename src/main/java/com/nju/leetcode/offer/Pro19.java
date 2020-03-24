package com.nju.leetcode.offer;

public class Pro19 {

    public boolean isMatch(String s, String p) {
        return process(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    public boolean process(char[] str, char[] exp, int i, int j) {
        if (j == exp.length) {
            return  i == str.length;
        }
        if (j+1 == exp.length || exp[j+1] != '*') {
            return  i!= str.length && (exp[j] == str[i] || exp[j] == '.')
                        && process(str, exp, i+1, j+1);
        }
        while (i!=str.length && (exp[j] == str[i] || exp[j] == '.')) {
            if (process(str, exp, i, j+2)) {
                return true;
            }
            i++;
        }
        return process(str, exp, i, j+2);
    }

    /**
     * 带注释的版本
     * @param str
     * @param exp
     * @param i
     * @param j
     * @return
     */

//    i,j代表str 和 exp都处理到哪一位了 i==str.leng+1 && j==exp.length+1代表处理完了
    public boolean proces1(char[] str, char[] exp, int i, int j) {
        // 对于exp和str都已经处理完了
        // 确保了后面exp[j]不越界
        if (j == exp.length) {
            return  i == str.length;
        }
        // j+1 == exp.length是保证 exp[j+1]不越界
        // 并且能走到下面的if{}，代表 要么j处理到最后一位了，要么exp[] 的j后至少还有一个没处理
        // 那么就判断当前位的exp和str是否相同，并递归判断下一位

        // i != str.length 是防止 str[i] 越界

        // 整体上说，这一个if是用来处理最后一位 以及 还有很多位，但exp[]的j的下一位不是*的情况
        if (j+1 == exp.length || exp[j+1] != '*') {
            return  i!= str.length && (exp[j] == str[i] || exp[j] == '.')
                    && proces1(str, exp, i+1, j+1);
        }

        //  能进入while()这一行，代表exp[]后面至少还有2个(加上当前位)位没处理
        //  并且exp[j+1]=*
        //  能进入循环体内部代码{}代表，exp[j]==str[i]或者当前位是.
        //  只有上面两种情况，代表能匹配上，才可以对*进行暴力匹配
        //  然后是一个不断暴力尝试i++和j+2的情况，是否能满足，如果有任何一个可以，就return true
        while (i!=str.length && (exp[j] == str[i] || exp[j] == '.')) {
            if (proces1(str, exp, i, j+2)) {
                return true;
            }
            i++;
        }
        // 处理exp[j+1] = *,但exp[j]和str[i]不能匹配，则放弃掉这个exp[j, j+1]的a*的这两位
        //  用i,j+2继续匹配
        return proces1(str, exp, i, j+2);
    }
}
