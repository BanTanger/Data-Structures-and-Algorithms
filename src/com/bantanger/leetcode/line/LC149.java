package com.bantanger.leetcode.line;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/17 17:42
 */
public class LC149 {
    class Solution {
        /*直接暴力算出两点斜率是否相同
        * 相似题目: */
        public int maxPoints(int[][] points) {
            if (points.length <= 2) return points.length;
            int res = 0;
            for (int i = 0; i < points.length - 2; i++) {
                for (int j = i + 1; j < points.length - 1; j++) {
                    int count = 2; // 两点构成一线，所以默认两点作为初始值
                    int x1 = points[i][0] - points[j][0];
                    int y1 = points[i][1] - points[j][1];
                    for (int k = j + 1; k < points.length; k++) {
                        int x2 = points[i][0] - points[k][0];
                        int y2 = points[i][1] - points[k][1];
                        if (x1 * y2 == x2 * y1) count++;
                    }
                    res = Math.max(res, count);
                }
            }
            return res;
        }
    }
}
