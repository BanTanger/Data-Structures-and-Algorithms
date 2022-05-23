package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 22:53
 */
public class LC191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n = n & (n - 1); // 消除数字 n 二进制形式最后一次出现的1
                res = -~res; // res++ 位运算装逼操作
                // 直到n == 0 时退出循环
            }
            return res;
        }
    }
}
