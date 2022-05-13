package com.bantanger.leetcode.prefix_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 8:33
 */
public class LC304_Matrix {
    class NumMatrix {
        // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            if (m == 0 || n == 0) return;
            // 构造前缀和矩阵
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 计算每个矩阵 [0, 0, i, j] 的元素和
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        // 计算子矩阵 [x1, y1, x2, y2] 的元素和
        public int sumRegion(int x1, int y1, int x2, int y2) {
            // 目标矩阵之和由四个相邻矩阵运算获得
            // 因为下标0被占用，所以每一个下标都要加一位
            x1++;
            y1++;
            x2++;
            y2++;

            // 记作 22 - 12 - 21 + 11 下标分别是 不减， 减第一位， 减第二位， 两位都减
            // 或者是 22 - 12(x - 1) - 21(y - 1) + 11(x - 1)(y - 1)
            return preSum[x2][y2] - preSum[x1 - 1][y2] - preSum[x2][y1 - 1] + preSum[x1 - 1][y1 - 1];
        }
    }
}
