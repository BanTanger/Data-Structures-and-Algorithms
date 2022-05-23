package com.bantanger.leetcode.bit_manipulation;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 23:14
 */
public class LC268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            // 先多补一个位置，但他装的是空
            int res = 0;
            // 先和新补的索引异或一下
            res ^= n;

            // 将数组的所有下标和元素异或
            // 因为异或满足交换律和结合律，所以3 ^ 2 ^ 3 = 2 ^ (3 ^ 3) = 2 ^ 0 = 2
            // 所以我们可以将现在的数字和下标看成是一一对应的，
            // 不是也没关系，反正之后的异或会将他们分配到一起
            for (int i = 0; i < n; i++) {
                res ^= nums[i] ^ i;
            }
            return res;
        }
    }
}
