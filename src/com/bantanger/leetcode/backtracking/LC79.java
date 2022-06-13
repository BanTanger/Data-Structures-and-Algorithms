package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/13 17:07
 */
public class LC79 {
    class Solution {
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 方向数组
        int n, m, len;
        boolean flag;
        String word;

        public boolean exist(char[][] board, String word) {
            this.word = word;
            n = board.length;
            m = board[0].length;
            int idx = 0;
            len = word.length();
            flag = false;
            // 先快速找到首字母，因为可能存在多个所以需要用到循环处理
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        // 寻找首字符, 如果找不到就代表没有这个单词
                        dfs(board, i, j, idx + 1); // 从找到坐标开始进行dfs搜索
                        // idx 表示移动长度
                        if(flag) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private void dfs(char[][] board, int i, int j, int idx) {
            if (idx > len) return;
//            // 小小剪枝，如果当前元素与模式串当前字符不匹配就直接结束本层递归
//            if (word.charAt(idx) != board[i][j]) return;
            // base case 如果当前idx已经达到word长度并且与word完全匹配，就标记flag为true
            if (idx == len) {
                flag = true;
                return;
            }

            // 先进行dfs把
            // 四个方向进行搜索
            if (i < 0 || i > n || j < 0 || j > m) return; // 四种边界情况处理
            for (int[] d : dir) {
                int x = d[0], y = d[1];
                dfs(board, i + x, j + y, idx + 1);
            }
        }
    }

    @Test
    public void test() {
        String word = "ABCB";
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Solution().exist(board, word));
    }
}
