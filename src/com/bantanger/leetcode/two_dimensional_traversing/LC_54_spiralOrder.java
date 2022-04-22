package com.bantanger.leetcode.two_dimensional_traversing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 23:06
 */
public class LC_54_spiralOrder {
    class Solution {
        /*
        确定循环不变量，从四个方向进行遍历，每遍历完一次就将边界缩小一次
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int n = matrix.length, m = matrix[0].length;
            // 上下左右四个边界
            int upperBound = 0, lowerBound = n - 1;
            int leftBound = 0, rightBound = m - 1;

            // 如果结果集合res大小已经等于二维数组大小，就代表遍历结束了
            while (res.size() != n * m) {
                if (upperBound <= lowerBound) {
                    // 在上边界从左往右遍历
                    for (int j = leftBound; j <= rightBound; j++) {
                        res.add(matrix[upperBound][j]);
                    }
                    // 上边界下移一位
                    upperBound++;
                }

                if (rightBound >= leftBound) {
                    // 在右边界从上到下遍历
                    for (int i = upperBound; i <= lowerBound; i++) {
                        res.add(matrix[i][rightBound]);
                    }
                    // 右边界左移一位
                    rightBound--;
                }

                if (lowerBound >= upperBound) {
                    // 在下边界从右往左遍历
                    for (int j = rightBound; j >= leftBound; j--) {
                        res.add(matrix[lowerBound][j]);
                    }
                    // 下边界上移一位
                    lowerBound--;
                }

                if (leftBound <= rightBound) {
                    // 在左边界从下到上遍历
                    for (int i = lowerBound; i >= upperBound; i--) {
                        res.add(matrix[i][leftBound]);
                    }
                    // 左边界右移一位
                    leftBound++;
                }
            }
            return res;
        }
    }
}
