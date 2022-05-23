package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 23:00
 */
public class LC136 {
    class Solution {
        public int singleNumber(int[] nums) {
            // 只要把所有数字进行异或，成对儿的数字就会变成 0，
            // 落单的数字和 0 做异或还是它本身，
            // 所以最后异或的结果就是只出现一次的元素
            int res = 0;
            for (int n : nums) {
                res ^= n;
            }
            return res;
        }
    }
}
