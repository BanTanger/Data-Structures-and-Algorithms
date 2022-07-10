package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/9 18:41
 */
public class offer15 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n -= lowbit(n);
                res++;
            }
            return res;
        }

        private int lowbit(int x) {
            // x & -x 能找到第一个1的位置
            // -x == 补码，即为 ~x + 1
            return x & (~x + 1);
        }
    }
}
