package com.bantanger.leetcode.double_pointer.two_points;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 23:04
 */
public class LC540_Bit {
    // 本题实际上和 LC136一模一样
    /* 本代码给出位操作写法，lc运行时间居然比二分慢
     * 倒也很好理解，位运算再快，他本质也是O(N)级别的算法，
     * 而二分是O(logN)级别的算法 */
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
