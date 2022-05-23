package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 22:56
 */
public class LC231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            // 如果一个数是二的幂数，那么他的二进制一定只有一个1
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
            // 进行一次消除运算后是否等于0，如果等就说明是二的幂数，否则不是
        }
    }
}