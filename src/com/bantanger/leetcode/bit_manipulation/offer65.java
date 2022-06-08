package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 19:54
 */
public class offer65 {
    class Solution {
        public int add(int a, int b) {
            // ^ 无进位相加 1 + 19 = 10 而不是 20 ，因为不管进位
            // & 求进位数， 1 + 9 = 1 而不是 10， 因为只管进位数，在这个基础上，我们可以左移一位让 1 变成 10
            // 合并两步，即能得到正确的加和结果
            // 重复这个步骤直到进位数为0
            if (a == 0) return b;
            int base = a ^ b;
            int up = a & b;
            return add(up << 1, base);
        }
    }
}
