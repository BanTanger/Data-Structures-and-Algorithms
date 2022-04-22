package com.bantanger.leetcode.two_dimensional_traversing;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:08
 */
public class LC_59_spiralOrderⅡ {
    class Solution {
        /*
        LC_54题相似，换汤不换药
         */
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int upperBound = 0, lowerBound = n - 1;
            int leftBound = 0, rightBound = n - 1;
            int count = 1;
            while (count <= n * n) {
                if (upperBound <= lowerBound) {
                    // 上边界从左往右放数据
                    for (int j = leftBound; j <= rightBound; j++) {
                        matrix[upperBound][j] = count++;
                    }
                    // 上边界下移
                    upperBound++;
                }

                if (rightBound >= leftBound) {
                    // 右边界从上到下放数据
                    for (int i = upperBound; i <= lowerBound; i++) {
                        matrix[i][rightBound] = count++;
                    }
                    // 右边界左移
                    rightBound--;
                }

                if (lowerBound >= upperBound) {
                    // 下边界从右往左放数据
                    for (int j = rightBound; j >= leftBound; j--) {
                        matrix[lowerBound][j] = count++;
                    }
                    // 下边界上移
                    lowerBound--;
                }

                if (leftBound <= rightBound) {
                    // 左边界从下到上放数据
                    for (int i = lowerBound; i >= upperBound; i--) {
                        matrix[i][leftBound] = count++;
                    }
                    // 左边界右移
                    leftBound++;
                }
            }
            return matrix;
        }
    }
}
