package com.bantanger.leetcode.math;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 8:18
 */
public class LC172 {
    class Solution {
        public int trailingZeroes(int n) {
            // 阶乘不要算出来，要算末尾有几个零，只需要找有多少个因子5就行了，因为5 * 2
            // 而所有偶数都能拆成2，所以不用担心2不够用。
            int res = 0;
            for (int d = n; d / 5 > 0; d /= 5) {
                res += d / 5;
            }
            return res;
        }
    }
}
