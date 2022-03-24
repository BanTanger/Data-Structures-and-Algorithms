package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/24 17:25
 */
public class LC_37_Sudoku {
    class Solution {
        public void solveSudoku(char[][] board) {
            solveSudokuHelper(board);
        }

        private boolean solveSudokuHelper(char[][] board) {
            // 双重循环遍历行列
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue; // 固定数字跳过
                    }
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValidSudoku(i, j, k, board)) {
                            board[i][j] = k;
                            if (solveSudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false; // 九个数都试完了没返回成功就废弃这种可能
                }
            }
            return true; //遍历完没有返回false，说明找到合适棋盘位置
        }

        private boolean isValidSudoku(int row, int col, char val, char[][] board) {
            // 同行查重
            for (int i = 0; i < 9; i++)
                if (board[row][i] == val) return false;
            // 同列查重
            for (int i = 0; i < 9; i++)
                if (board[i][col] == val) return false;
            // 九宫格重复
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++)
                for (int j = startCol; j < startCol + 3; j++)
                    if (board[i][j] == val) return false;
            return true;
        }
    }
    @Test
    public void test(){
        char[][] arr = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Solution().solveSudoku(arr);
    }
}
