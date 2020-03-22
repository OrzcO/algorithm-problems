package com.nju.leetcode.offer;

import org.junit.Test;

public class Pro12 {

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     *
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     *
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     * dfs
     *
     * @param board
     * @param word
     * @return
     */

    private int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }
        int row = board.length, col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        return dfs(visit, board, 0, 0, word, -1);
    }

    private boolean dfs(boolean[][] visit, char[][] board, int i, int j, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (idx == -1) {
            char cur = word.charAt(0);
            for (int m=0;m<board.length;m++) {
                for (int n=0;n<board[0].length;n++) {
                    if (cur == board[m][n]) {
                        visit[m][n] = true;
                        if (dfs(visit, board, m, n, word, 1)) {
                            return true;
                        }
                        visit[m][n] = false;
                    }
                }
            }
        } else {
            for (int m=0;m<4;m++) {
                if (i + dir[m][0] < board.length && i + dir[m][0] >= 0
                        && j + dir[m][1] < board[0].length && j+ dir[m][1] >= 0
                        && board[i + dir[m][0]][j + dir[m][1]] == word.charAt(idx)
                        && !visit[i + dir[m][0]][j + dir[m][1]]) {
                    visit[i + dir[m][0]][j + dir[m][1]] = true;
                    if (dfs(visit, board, i + dir[m][0], j + dir[m][1], word, idx+1)) {
                        return true;
                    }
                    visit[i + dir[m][0]][j + dir[m][1]] = false;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'a','b'},{'c','d'}}, "abcd"));
    }
}
