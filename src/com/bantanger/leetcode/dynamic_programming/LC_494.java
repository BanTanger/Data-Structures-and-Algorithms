package com.bantanger.leetcode.dynamic_programming;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/7 11:51
 */
public class LC_494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // 变成划分子集问题，划分子集又可以归为01背包问题
            // 公式为 sum(A) = target + sum(nums) >> 2
            int sum = 0;
            for (int i : nums) sum += i;
            // 如果和为奇数没有方案边界处理，返回方案数零
            if ((target + sum) % 2 != 0) return 0;
            int size = (target + sum) >> 1;
            if (size < 0) size = -size; // 防止target为负数
            int[] dp = new int[size + 1];
            // dp初始化
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = size; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[size];
        }
    }

}
