package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/3 8:43
 */
public class LC_62_Math_Combination {
    class Solution {
        public int uniquePaths(int m, int n) {
            long numerator = 1; // 分子
            int denominator = m - 1; // 分母
            int count = m - 1;
            int t = m + n - 2;
            while (count-- > 0) {
                numerator *= (t--); // 分子计算
                // 不断除分母
                while (denominator != 0 && numerator % denominator == 0) { // 能整除分母时
                    numerator /= denominator;
                    denominator--;
                }
            }
            return (int) numerator;
        }
    }
}
