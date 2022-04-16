package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/16 11:36
 */
public class LC_479_2022_04_16 {
    class Solution {
        public int largestPalindrome(int n) {
            // 特殊情况
            if (n == 1) return 9;
            // 获得n位数的最大值
            int max = (int) Math.pow(10, n) - 1;
            // 从最大值开始遍历回文数的左半部分
            for (int i = max; i >= 0; i--) {
                // 获得回文数左半部分
                long num = i, t = i;
                // 构造完整回文串，翻转左半部分到自身尾部
                while (t != 0) {
                    num = num * 10 + (t % 10);
                    t /= 10;
                }
                // 两数乘积一定大于两数拼接，从n位数的最大值开始往下遍历
                for (long j = max; j * j >= num; j--) {
                    if (num % j == 0) return (int) (num % 1337);
                }
            }
            return -1;
        }
    }
}
