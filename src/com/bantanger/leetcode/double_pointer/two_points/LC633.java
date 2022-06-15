package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 23:07
 */
public class LC633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
        /* 满足题意的两个量必须会落在[0, sqrt(c)]
            所以对这个边界进行二分即可
        */
            int a = 0, b = (int) Math.sqrt(c);
            while (a <= b) {
                if (a * a + b * b == c) return true;
                else if (a * a + b * b < c) a++; /* 左边界小了，往右移动 */
                else b--; /* 右边界大了，往左移动 */
            }
            return false;
        }
    }
}
