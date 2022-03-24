package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/24 16:22
 */
public class LC_51_QueueN {
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 创建棋盘
            char[][] chessboard = new char[n][n];
            for (char[] c : chessboard) {
                Arrays.fill(c, '.');
            }
            backtracking(n, 0, chessboard);
            return res;
        }

        public void backtracking(int n, int row, char[][] chessboard) {
            if (row == n) {
                res.add(Array2List(chessboard));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isValue(row, col, n, chessboard)) {
                    chessboard[row][col] = 'Q';
                    backtracking(n, row + 1, chessboard);
                    chessboard[row][col] = '.';
                }
            }
        }

        public List Array2List(char[][] chessboard) {
            List<String> list = new ArrayList<>();
            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }

        private boolean isValue(int row, int col, int n, char[][] chessboard) {
            // 查看当前行
            for (int i = 0; i < row; i++)
                if (chessboard[i][col] == 'Q') return false;
            // 查看45度对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
                if (chessboard[i][j] == 'Q') return false;
            // 查看135度对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++)
                if (chessboard[i][j] == 'Q') return false;
            return true;
        }
    }

    @Test
    public void test(){
        List<List<String>> res = new ArrayList<>();
        res = new Solution().solveNQueens(4);
        for(List<String> num : res){
            for(String s : num){
                for(int i = 0;i < s.length();i++){
                    System.out.print(s.charAt(i) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
